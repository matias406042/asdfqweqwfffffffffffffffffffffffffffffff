package ar.edu.utn.frc.tup.lc.iv.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suppliers")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplier_id;
    private String name;
    @Column(name = "health_insurance")
    private Long healthInsurance;
    private boolean authorized;
    private String address;
    @Column(name = "supplier_type_id")
    private Integer supplierTypeId;
    private String description;


    @Column(name = "created_datetime")
    private String createdDatetime;
    @Column(name = "created_user")
    private String createdUser;
    @Column(name = "last_update_datetime")
    private String lastUpdateDatetime;
    @Column(name = "last_updated_user")
    private String lastUpdatedUser;




    /*Id
Name
Address
Health_Insurance
Authorized
Supplier_Type_id
Description
Created_datetime
Created_user
Last_update_datetime
Last_updated_user*/
//todo capaz faltan cosas en las entities
}
