package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProductDTO {
    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;
    @NotNull(message = "Reusable is required")
    private boolean reusable;
    @NotNull(message = "The minimum amount for warning is required")
    private int minAmountWarning;
    @NotNull(message = "The amount is required")
    private int amount;
    @JsonProperty("supplier_id")
    private Integer supplierId;
    private String description;
    @NotNull
    private double unitPrice;
    @NotNull
    @JsonProperty("category_id")
    private int categoryId;



}
