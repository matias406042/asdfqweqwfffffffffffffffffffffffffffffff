package ar.edu.utn.frc.tup.lc.iv.entities;

import ar.edu.utn.frc.tup.lc.iv.models.enums.AmountModificationType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class AmountModificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable= false)
    private Integer id;
    @Column(name = "amount")
    private  Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;




    @Column(name = "description")
    private  String description;

    @Column(name = "date")
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "modification_type")
    private AmountModificationType type;

    @Column(name = "created_datetime")
    LocalDateTime createdDatetime;

    @Column(name = "created_user")
    Integer createdUser;

    @Column(name = "last_updated_datetime")
    LocalDateTime lastUpdatedDatetime;

    @Column(name = "last_updated_user")
    Integer lastUpdatedUser;
}