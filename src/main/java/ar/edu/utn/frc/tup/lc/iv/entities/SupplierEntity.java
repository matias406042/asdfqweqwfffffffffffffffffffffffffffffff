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
    private Integer id;
    private String name;
    @Column(name = "health_insurance")
    private Long healthInsurance;
    private boolean authorized;
    private Long address;
//todo capaz faltan cosas en las entities
}
