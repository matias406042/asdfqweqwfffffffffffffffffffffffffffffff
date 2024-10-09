package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.entities.CategoryEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import ar.edu.utn.frc.tup.lc.iv.models.Product;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productJRepository;

  /*  @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> entityList = productJRepository.findAll();
        List<Product> products = new ArrayList<>();

        for (ProductEntity p : entityList) {
            products.add(new Product(p.getId(),p.getName(),p.getReusable(),null,p.getMinQuantityWarning(),p.getAmount(),
                    null,p.getCreatedDatetime(),p.getCreatedUser(),p.getLastUpdatedDatetime(),p.getLastUpdatedUser()));
        }

        return products;
    }*/ //todo tomi

  /*  @Override
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
    }*/ //todo tomi

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> entityList = productJRepository.findAll();
        List<Product> products = new ArrayList<>();

        for (ProductEntity p : entityList) {

            CategoryEntity categoryEntity = p.getCategory();
            ProductCategory category = new ProductCategory(categoryEntity.getId(), categoryEntity.getCategory());

            products.add(new Product(p.getId(),p.getName(),p.getReusable(), category ,p.getMinQuantityWarning(),
                    null));
        }

        return products;
    }
}
