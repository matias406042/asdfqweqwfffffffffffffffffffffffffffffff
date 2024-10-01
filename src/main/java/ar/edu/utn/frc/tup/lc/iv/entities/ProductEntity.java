package ar.edu.utn.frc.tup.lc.iv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private Integer stock;
    private boolean active;
    private boolean reusable;
    @Column(name = "min_amount_warning")
    private int minAmountWarning;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private ProductsCategoriesEntity category;

    @OneToMany()
    private List<DetailProductEntity> detailProduct;



}
