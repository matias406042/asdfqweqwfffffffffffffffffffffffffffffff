package ar.edu.utn.frc.tup.lc.iv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class ProductEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "reusable")
    Boolean reusable;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    CategoryEntity category;

    @Column(name = "min_quantity_warning")
    Integer minQuantityWarning;


    @Column(name = "created_datetime")
    LocalDateTime createdDatetime;

    @Column(name = "created_user")
    Integer createdUser;

    @Column(name = "last_updated_datetime")
    LocalDateTime lastUpdatedDatetime;

    @Column(name = "last_updated_user")
    Integer lastUpdatedUser;

    @OneToMany(mappedBy = "product")
    List<DetailProductEntity> detailProducts;
}

