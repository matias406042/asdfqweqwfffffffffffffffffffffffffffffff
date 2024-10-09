package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import ar.edu.utn.frc.tup.lc.iv.models.enums.DetailProductState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductXDetailDTO {
    //atributos del producto
    private Integer product_id;
    private String name;
    private boolean active;
    private boolean reusable;
    private int min_amount_warning;
    private String category;
    //atributos del detalle
    private String detail;
    private DetailProductState state;
    private double unit_price;
    @JsonProperty("supplier_id")
    private Integer supplier_id;





}
