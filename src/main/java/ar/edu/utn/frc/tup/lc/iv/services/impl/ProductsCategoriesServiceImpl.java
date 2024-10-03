package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.entities.ProductsCategoriesEntity;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductsCategoriesRepository;
import ar.edu.utn.frc.tup.lc.iv.services.ProductsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductsCategoriesServiceImpl implements ProductsCategoriesService {
    @Autowired
    private ProductsCategoriesRepository productsCategoriesRepository;

    public ProductsCategoriesServiceImpl(ProductsCategoriesRepository productsCategoriesRepository) {
        this.productsCategoriesRepository = productsCategoriesRepository;
    }

    @Override
    public Iterable<ProductCategory> getProductsCategories() {
        return productsCategoriesRepository.findAll().stream().map(productsCategoriesEntity -> new ProductCategory(productsCategoriesEntity.getCategory())).collect(Collectors.toList());
    }

    public ProductsCategoriesEntity getProductCategoryById(Integer id) {
        return productsCategoriesRepository.findById(id).orElse(null);
    }
}
