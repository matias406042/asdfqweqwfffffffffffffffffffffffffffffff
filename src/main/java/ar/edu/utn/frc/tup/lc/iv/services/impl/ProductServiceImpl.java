package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CreateProductDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.ProductXDetailDTO;
import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductsCategoriesEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.SupplierEntity;
import ar.edu.utn.frc.tup.lc.iv.models.State;
import ar.edu.utn.frc.tup.lc.iv.repositories.DetailProductRepository;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.DetailProductService;
import ar.edu.utn.frc.tup.lc.iv.services.ProductService;
import ar.edu.utn.frc.tup.lc.iv.services.ProductsCategoriesService;
import ar.edu.utn.frc.tup.lc.iv.services.SupplierService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private DetailProductService detailProductService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductsCategoriesService productsCategoriesService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper,
                              DetailProductService detailProductService, SupplierService supplierService,
                              ProductsCategoriesService productsCategoriesService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.detailProductService = detailProductService;
        this.supplierService = supplierService;
        this.productsCategoriesService = productsCategoriesService;
    }

    //si no existe un producto con:
    // -el mismo nombre
    // -un proveedor inexistente
    // -una categoria inexistente
    // , se crea un nuevo producto junto con su detalle
    @Override
    @Transactional
    public ProductXDetailDTO createProduct(CreateProductDTO DTO) {
        ArrayList<ProductEntity> products =productRepository.findByName(DTO.getName());
        if(products.size()>0){
            if(products.size()==1){
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Ya existe un producto con ese nombre");
            }else{
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Existen "+products.size()+" productos con ese nombre");
            }
        }
        SupplierEntity supplier = null;
        if(DTO.getSupplierId() != null){
            supplier = supplierService.getSupplierById(DTO.getSupplierId());
            if(supplier==null){
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"No existe el proveedor ingresado");
            }
        }
        ProductsCategoriesEntity category = productsCategoriesService.getProductCategoryById(DTO.getCategoryId());
        if(category==null){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"No existe la categoria ingresada");
        }
        ProductEntity Pentity = new ProductEntity(DTO.getName(),true,DTO.getReusable(),DTO.getMin_amount_warning(),category);
        List<DetailProductEntity> Dentities = new ArrayList<>();
        for (int i = 0; i < DTO.getAmount(); i++) {
            DetailProductEntity Dentity = new DetailProductEntity(DTO.getDescription(), State.available, Pentity, DTO.getUnit_price(), supplier);
            Dentities.add(Dentity);
        }
        detailProductService.saveAll(Dentities);
        productRepository.save(Pentity);
        ProductXDetailDTO response= modelMapper.map(Pentity, ProductXDetailDTO.class);
        //el response ProductXDetailDTO solo representa un producto y todos sus items/detalles
        response.setDetail(Dentities.get(0).getDetail());
        response.setState(Dentities.get(0).getState());
        response.setUnit_price(Dentities.get(0).getUnitPrice());
        response.setProduct_id(Pentity.getProduct_id());
        response.setSupplier_id(supplier.getSupplier_id());
        return response;
    }
}
