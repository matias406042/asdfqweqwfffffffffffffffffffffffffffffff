package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CreateProductDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.ProductXDetailDTO;
import ar.edu.utn.frc.tup.lc.iv.entities.*;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import ar.edu.utn.frc.tup.lc.iv.models.State;
import ar.edu.utn.frc.tup.lc.iv.models.Supplier;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.DetailProductService;
import ar.edu.utn.frc.tup.lc.iv.services.ProductsCategoriesService;
import ar.edu.utn.frc.tup.lc.iv.services.SupplierService;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import javax.swing.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
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

    @Autowired
    private ModelMapper modelMapper;


    @Test
    void createProduct() {
        ArrayList<ProductEntity> products = new ArrayList<ProductEntity>();
        SupplierEntity supplier = new SupplierEntity();
        supplier.setId(1);
        ProductsCategoriesEntity category = new ProductsCategoriesEntity();
        category.setId(1);
        category.setCategory("category");
        CreateProductDTO dto= new CreateProductDTO("Producto1",true,1,1,1,"description",1,1);
        ProductEntity productEntity = new ProductEntity("Producto1",1,true,true,1,category);
        ProductEntity productEntity2 = new ProductEntity("Producto1",1,true,true,1,category);
        productEntity2.setId(1);
        DetailProductEntity detailProductEntity = new DetailProductEntity("description", State.available, productEntity, 1, supplier);
        ProductXDetailDTO expected = new ProductXDetailDTO(1,"Producto1",1,true,true,1,"category",
                "description",State.available,1,1,1);

        when(productRepository.findByName("Producto1")).thenReturn(products);
        when(supplierService.getSupplierById(1)).thenReturn(supplier);
        when(productsCategoriesService.getProductCategoryById(1)).thenReturn(category);
        when(detailProductService.saveDetailProduct(eq(detailProductEntity))).thenReturn(detailProductEntity);
        when(productRepository.save(eq(productEntity))).thenReturn(productEntity2);

        ProductXDetailDTO result = productService.createProduct(dto);
        Assertions.assertEquals(expected,result);
    }
    

}