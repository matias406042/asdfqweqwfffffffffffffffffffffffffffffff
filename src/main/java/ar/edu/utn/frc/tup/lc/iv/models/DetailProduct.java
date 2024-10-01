package ar.edu.utn.frc.tup.lc.iv.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailProduct {
    private Long id;
    private String detail;
    private State state;
    private Product product;
    private Double unitPrice;
    private Supplier supplier;
}
