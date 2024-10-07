package ar.edu.utn.frc.tup.lc.iv.Entities;

import ar.edu.utn.frc.tup.lc.iv.Models.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products_Details")
public class DetailProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    ProductEntity product;

    @Column(name = "description")
    String description;

    @Column(name = "supplier_id")
    Integer supplierId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    StateEntity state;

    @Column(name = "created_datetime")
    LocalDateTime createdDatetime;

    @Column(name = "created_user")
    Integer createdUser;

    @Column(name = "last_updated_datetime")
    LocalDateTime lastUpdatedDatetime;

    @Column(name = "last_updated_user")
    Integer lastUpdatedUser;
}
