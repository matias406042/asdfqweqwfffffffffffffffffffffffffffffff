package ar.edu.utn.frc.tup.lc.iv.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String name;
    private boolean active;
    private boolean reusable;
    @Column(name = "min_amount_warning")
    @JsonProperty("min_amount_warning")
    private int min_amount_warning;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private ProductsCategoriesEntity category;


    public ProductEntity(String name, boolean active, boolean reusable, int minAmountWarning, ProductsCategoriesEntity category) {
        this.name = name;
        this.active = active;
        this.reusable = reusable;
        this.min_amount_warning = minAmountWarning;
        this.category = category;
    }



}
