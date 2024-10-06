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
import org.springframework.web.client.HttpClientErrorException;

import javax.swing.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
    void createProduct_positive() {
        ArrayList<ProductEntity> products = new ArrayList<ProductEntity>();
        SupplierEntity supplier = new SupplierEntity();
        supplier.setSupplier_id(1);
        ProductsCategoriesEntity category = new ProductsCategoriesEntity();
        category.setCategory_id(1);
        category.setCategory("category");
        CreateProductDTO dto= new CreateProductDTO("Producto1",true,1,1,1,"description",1,1);
        List<DetailProductEntity> detailProductEntities = new ArrayList<>();
        detailProductEntities.add(new DetailProductEntity("description", State.available, new ProductEntity(), 1, supplier));

        /*String name, boolean active, boolean reusable, int minAmountWarning, ProductsCategoriesEntity categor*/
        /**/

        ProductEntity productEntity = new ProductEntity("Producto1",true,true,1,category);
        ProductEntity productEntity2 = new ProductEntity("Producto1",true,true,1,category);
        productEntity2.setProduct_id(1);
        ProductXDetailDTO expected = new ProductXDetailDTO(null,"Producto1",true,true,1,"category",
                "description",State.available,1,1);

        when(productRepository.findByName("Producto1")).thenReturn(products);
        when(supplierService.getSupplierById(1)).thenReturn(supplier);
        when(productsCategoriesService.getProductCategoryById(1)).thenReturn(category);
        when(detailProductService.saveAll(any())).thenReturn(detailProductEntities);
        when(productRepository.save(eq(productEntity))).thenReturn(productEntity2);

        ProductXDetailDTO result = productService.createProduct(dto);
        Assertions.assertEquals(expected,result);
    }
    /*public ProductXDetailDTO createProduct(CreateProductDTO DTO) {
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
        Dentities=detailProductService.saveAll(Dentities);
        Pentity.setDetailProduct(Dentities);
        productRepository.save(Pentity);
        ProductXDetailDTO response= modelMapper.map(Pentity, ProductXDetailDTO.class);
        //el response ProductXDetailDTO solo representa un producto y todos sus items/detalles
        response.setDetail(Dentities.get(0).getDetail());
        response.setState(Dentities.get(0).getState());
        response.setUnit_price(Dentities.get(0).getUnitPrice());
        response.setProduct_id(Pentity.getProduct_id());
        response.setSupplier_id(supplier.getSupplier_id());
        return response;
    }*/
    @Test
    void createProduct_positi9ive() {
        ArrayList<ProductEntity> products = new ArrayList<ProductEntity>();
        SupplierEntity supplier = new SupplierEntity();
        supplier.setSupplier_id(1);
        ProductsCategoriesEntity category = new ProductsCategoriesEntity();
        category.setCategory_id(1);

        when(productRepository.findByName("Producto1")).thenReturn(products);
        when(supplierService.getSupplierById(1)).thenReturn(supplier);
        when(productsCategoriesService.getProductCategoryById(1)).thenReturn(category);
        when(detailProductService.saveDetailProduct(any(DetailProductEntity.class))).thenReturn(new DetailProductEntity());
        when(productRepository.save(any(ProductEntity.class))).thenReturn(new ProductEntity());

    }

    @Test
    void createProduct_name_already_exists() {
        ArrayList<ProductEntity> products = new ArrayList<ProductEntity>();
        products.add(new ProductEntity());
        CreateProductDTO dto= new CreateProductDTO("Producto1",true,1,1,1,"description",1,1);

        when(productRepository.findByName("Producto1")).thenReturn(products);

        Assertions.assertThrows(HttpClientErrorException.class, () -> productService.createProduct(dto));
    }

    @Test
    void createProduct_supplier_doesnt_exists() {
        CreateProductDTO dto= new CreateProductDTO("Producto1",true,1,1,1,"description",1,1);

        when(supplierService.getSupplierById(1)).thenReturn(null);

        Assertions.assertThrows(HttpClientErrorException.class, () -> productService.createProduct(dto));
    }

    @Test
    void createProduct_category_doesnt_exists() {
        CreateProductDTO dto= new CreateProductDTO("Producto1",true,1,1,1,"description",1,1);

        when(productsCategoriesService.getProductCategoryById(1)).thenReturn(null);

        Assertions.assertThrows(HttpClientErrorException.class, () -> productService.createProduct(dto));
    }
    

}