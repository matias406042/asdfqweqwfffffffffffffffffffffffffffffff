package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductXDetailDTO {
    private int id;
    private String name;
    private boolean reusable;
    private int minAmountWarning;
    private int amount;
    private int supplierId;
    private String description;
    private double unitPrice;

}
