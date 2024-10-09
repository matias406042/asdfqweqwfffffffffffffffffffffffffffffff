package ar.edu.utn.frc.tup.lc.iv.services.Impl;

import ar.edu.utn.frc.tup.lc.iv.models.DetailProduct;
import ar.edu.utn.frc.tup.lc.iv.repositories.DetailProductJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.services.IDetailProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DetailProductServiceImpl implements IDetailProductService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    DetailProductJpaRepository detailRepository;


   /* @Override
    public List<DetailProduct> getDetailByProductId(Integer id) {
        Optional<List<DetailProductEntity>> optionalList = detailRepository.findAllByProductId(id);
        List<DetailProduct> detailProductList = new ArrayList<>();

        optionalList.ifPresent( Details ->{
            for (DetailProductEntity d : Details){

                if (id == d.getProduct().getId()){
                    detailProductList.add(new DetailProduct(d.getId(),d.getProduct().getId(),d.getDescription(),
                            d.getSupplier(), modelMapper.map(d.getState(), State.class), d.getCreatedDatetime(), d.getCreatedUser(), d.getLastUpdatedDatetime(),
                            d.getLastUpdatedUser()));
                }
            }
        } );

        return detailProductList;
    }*/ //todo agus

    @Override
    public List<DetailProduct> getDetailProducts() {
        return null;
    }
}
