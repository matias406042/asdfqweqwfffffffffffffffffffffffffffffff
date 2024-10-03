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
        ProductEntity Pentity = modelMapper.map(DTO, ProductEntity.class);
        DetailProductEntity Dentity = modelMapper.map(DTO, DetailProductEntity.class);
        Dentity.setState(State.available);
        Dentity.setProduct(Pentity);
        Dentity.setSupplier(supplier);
        Dentity=detailProductService.saveDetailProduct(Dentity);
        Pentity.setCategory(category);
        Pentity=productRepository.save(Pentity);
        return modelMapper.map(Dentity, ProductXDetailDTO.class);
    }
}
