package ar.edu.utn.frc.tup.lc.iv.services.Impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.ammountModification.request.DecrementModificationRequestDto;
import ar.edu.utn.frc.tup.lc.iv.entities.AmountModificationEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import ar.edu.utn.frc.tup.lc.iv.models.AmountModification;
import ar.edu.utn.frc.tup.lc.iv.models.Product;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import ar.edu.utn.frc.tup.lc.iv.models.enums.AmountModificationType;
import ar.edu.utn.frc.tup.lc.iv.repositories.AmountModificationJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.repositories.DetailProductJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.AmountModificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmountModificationServiceImpl implements AmountModificationService {

    private final AmountModificationJpaRepository amountModificationJpaRepository;
    private final ModelMapper modelMapper;
    private final DetailProductJpaRepository detailProductRepository;

    @Autowired
    public AmountModificationServiceImpl(AmountModificationJpaRepository amountModificationJpaRepository, ModelMapper modelMapper, DetailProductJpaRepository detailProductRepository) {
        this.amountModificationJpaRepository = amountModificationJpaRepository;
        this.modelMapper = modelMapper;
        this.detailProductRepository = detailProductRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<String> giveLogicalLow (DecrementModificationRequestDto dto) {
        try {

            //get  details x ids  validate not null  and discontinue false( present and active)

            List<DetailProductEntity> lstDPE = getActivesXIds(dto.getIds());
            ProductEntity productEntity = lstDPE.get(0).getProduct();
            List<DetailProductEntity>lstActivosXProducto = getActivesXProducto(productEntity);
            //set variable product


            //validate disminution posibility
            if (lstDPE.size() < dto.getIds().size()) {
                throw new Exception("insufficient stock quantity");
            }

            ///iterate details to save his changes
            for (DetailProductEntity dp : lstDPE) {
                for (Integer i : dto.getIds()) {

                    dp.setDiscontinued(true);
                    detailProductRepository.save(dp);
                }
            }
            /// control amount product after change the status product(discontinued)

            if (productEntity.getMinQuantityWarning() >= lstActivosXProducto.size()-lstDPE.size()) {
                // TODO:generar notificacion a administracion


            }
            //  post  Amountmodification to decrement

            var c = new ProductCategory();
            c.setCategoryId(productEntity.getCategory().getId());
            c.setCategoryName(productEntity.getCategory().getCategory());

            Product p = new Product();
            p.setId(productEntity.getId());
            p.setName(productEntity.getName());
            p.setCategory(c);


            AmountModification a = new AmountModification();
            a.setAmount(dto.getIds().size());
            a.setDate(new Date());
            a.setProduct(p);
            a.setModificationType(AmountModificationType.DECREMENT);
            a.setDescription(dto.getJustify());
            amountModificationJpaRepository.save(modelMapper.map(a,AmountModificationEntity.class));
            return  ResponseEntity.ok("OPERACION EXITOSA");

        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }



     public List<DetailProductEntity>getActivesXProducto(ProductEntity p)  {


        List<DetailProductEntity> lstDPE = new ArrayList<DetailProductEntity>() ;

        for (DetailProductEntity d : p.getDetailProducts()) {
            if (!d.getDiscontinued()){
                lstDPE.add(d);
            }
        }

        return lstDPE;

    }


     public List<DetailProductEntity>getActivesXIds(List<Integer> ids) throws Exception {


        List<DetailProductEntity> lstDPE = new ArrayList<DetailProductEntity>() ;
        //traer  detalles y validar que existan y esten vigentes
        for (Integer id : ids) {
            var detEntt= detailProductRepository.findById(id).orElseThrow(()
                    -> new Exception("Detail product not found for id: " + id));
            if (detEntt.getDiscontinued()){
                throw new Exception("Detail product with id: " + id + " is no active (this was already discontinued)");
            }
            lstDPE.add(detEntt);
        }

        return lstDPE;

    }
}
