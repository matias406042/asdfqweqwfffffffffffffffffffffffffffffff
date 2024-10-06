package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import ar.edu.utn.frc.tup.lc.iv.services.ProductsCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsCategoriesController {

    @Autowired
    private ProductsCategoriesService productsCategoriesService;
    public ProductsCategoriesController(ProductsCategoriesService productsCategoriesService) {
        this.productsCategoriesService = productsCategoriesService;
    }

    @GetMapping("/products/categories")
    public ResponseEntity<Iterable<ProductCategory>> getProductsCategories() {
        return ResponseEntity.ok(productsCategoriesService.getProductsCategories());
    }
}
