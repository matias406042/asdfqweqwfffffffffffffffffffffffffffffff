package ar.edu.utn.frc.tup.lc.iv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String description;
    private Integer stock;
    private boolean active;
    private boolean reusable;
    private int minAmountWarning;
    private ProductCategory category;
    private List<DetailProduct> detailsProduct;
}
