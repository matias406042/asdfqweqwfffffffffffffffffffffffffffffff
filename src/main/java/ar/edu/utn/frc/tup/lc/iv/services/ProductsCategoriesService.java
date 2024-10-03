package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.entities.ProductsCategoriesEntity;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;

public interface ProductsCategoriesService {
    Iterable<ProductCategory> getProductsCategories();
    ProductsCategoriesEntity getProductCategoryById(Integer id);
}
