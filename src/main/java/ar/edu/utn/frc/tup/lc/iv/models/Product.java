package ar.edu.utn.frc.tup.lc.iv.models;

import ar.edu.utn.frc.tup.lc.iv.models.DetailProduct;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
   private Integer id;
   private String name;
   private Boolean reusable;
   private ar.edu.utn.frc.tup.lc.iv.models.ProductCategory category;
   private Integer minQuantityWarning;
   private List<DetailProduct> detailProducts;
}
