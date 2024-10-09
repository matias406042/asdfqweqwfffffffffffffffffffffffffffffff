package ar.edu.utn.frc.tup.lc.iv.controllers;
import ar.edu.utn.frc.tup.lc.iv.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.utn.frc.tup.lc.iv.services.ICategoryService;
import ar.edu.utn.frc.tup.lc.iv.services.IDetailProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Qualifier("productServiceImpl")
    @Autowired
    IProductService productService;

    @Qualifier("detailProductServiceImpl")
    @Autowired
    IDetailProductService detailProductService;

    @Qualifier("categoryServiceImpl")
    @Autowired
    ICategoryService categoryService;


   /* @GetMapping("/getAll")
    public ResponseEntity getAllProducts() {
        List<Product> products = productService.getAllProducts();

        if (Objects.isNull(products)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The are not categories loaded");

        for (Product p : products) {
            p.setDetailProducts(detailProductService.getDetailByProductId(p.getId()));
            //if (p.getCategory() == null) { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The are not categories loaded"); }
            //p.setCategory(categoryService.getCategoryById());
        }

        return ResponseEntity.ok(products);
    }*/

/*
    @PostMapping("/product")
    public ResponseEntity<ProductXDetailDTO> createProduct(@RequestBody @Valid CreateProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }*/
    //todo
}
