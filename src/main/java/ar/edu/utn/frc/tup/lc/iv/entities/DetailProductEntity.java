package ar.edu.utn.frc.tup.lc.iv.entities;

import ar.edu.utn.frc.tup.lc.iv.models.State;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Table(name = "detail_products")
public class DetailProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detail;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Column(name = "unit_price")
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplier;

    public DetailProductEntity(String detail, State state, ProductEntity product, double unitPrice, SupplierEntity supplier) {
        this.detail = detail;
        this.state = state;
        this.product = product;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
    }


}
