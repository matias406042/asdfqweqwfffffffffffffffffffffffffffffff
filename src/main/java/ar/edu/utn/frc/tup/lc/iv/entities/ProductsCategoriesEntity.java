package ar.edu.utn.frc.tup.lc.iv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "products_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsCategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;

    private String category;


    @Column(name = "created_datetime")
    private String createdDatetime;
    @Column(name = "created_user")
    private String createdUser;
    @Column(name = "last_update_datetime")
    private String lastUpdateDatetime;
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;

}

