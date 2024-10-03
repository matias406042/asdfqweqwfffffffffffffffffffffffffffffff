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
    @Column(name = "id")
    private Integer id;
    private String name;
    private Integer stock;
    private boolean active;
    private boolean reusable;
    @Column(name = "min_amount_warning")
    @JsonProperty("min_amount_warning")
    private int min_amount_warning;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private ProductsCategoriesEntity category;

    @OneToMany()
    private List<DetailProductEntity> detailProduct;

    public ProductEntity(String name, Integer stock, boolean active, boolean reusable, int minAmountWarning, ProductsCategoriesEntity category) {
        this.name = name;
        this.stock = stock;
        this.active = active;
        this.reusable = reusable;
        this.min_amount_warning = minAmountWarning;
        this.category = category;
    }



}
