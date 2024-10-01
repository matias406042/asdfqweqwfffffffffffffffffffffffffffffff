package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateProductDTO {
    @NotNull
    @NotEmpty
    private String name;
    private boolean reusable;
    @NotNull
    private int minAmountWarning;
    @NotNull
    private int amount;
    private int supplierId;
    private String description;
    @NotNull
    private double unitPrice;
    @NotNull
    private int categoryId;



}
