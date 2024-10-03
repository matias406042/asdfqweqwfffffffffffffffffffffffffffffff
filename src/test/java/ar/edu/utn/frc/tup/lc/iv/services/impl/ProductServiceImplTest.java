package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CreateProductDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.ProductXDetailDTO;
import ar.edu.utn.frc.tup.lc.iv.entities.*;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import ar.edu.utn.frc.tup.lc.iv.models.Supplier;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.DetailProductService;
import ar.edu.utn.frc.tup.lc.iv.services.ProductsCategoriesService;
import ar.edu.utn.frc.tup.lc.iv.services.SupplierService;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import javax.swing.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @SpyBean
    private ProductServiceImpl productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private SupplierService supplierService;

    @MockBean
    private ProductsCategoriesService productsCategoriesService;

    @MockBean
    private DetailProductService detailProductService;

    @Test
    void createProduct() {
        ArrayList<ProductEntity> products = new ArrayList<ProductEntity>();
        ProductEntity productEntity = new ProductEntity();
        SupplierEntity supplier = new SupplierEntity();
        products.add(productEntity);
        ProductsCategoriesEntity category = new ProductsCategoriesEntity();
        CreateProductDTO dto= new CreateProductDTO("Producto1",true,1,1,1,"description",1,1);
        DetailProductEntity detailProductEntity = new DetailProductEntity();
        ProductXDetailDTO expected = new ProductXDetailDTO();

        when(productRepository.findByName(any())).thenReturn(products);
        when(supplierService.getSupplierById(any())).thenReturn(supplier);
        when(productsCategoriesService.getProductCategoryById(any())).thenReturn(category);
        when(detailProductService.saveDetailProduct(any())).thenReturn(detailProductEntity);
        when(productRepository.save(any())).thenReturn(productEntity);

        
    }

    /*//si no existe un producto con:
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
    }*/
}