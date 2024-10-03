package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductsCategoriesEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.SupplierEntity;
import ar.edu.utn.frc.tup.lc.iv.models.State;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductXDetailDTO {


    //atributos del producto
    private Integer id;
    private String name;
    private Integer stock;
    private boolean active;
    private boolean reusable;
    private int min_amount_warning;
    private String category;
    //atributos del detalle
    private String detail;
    private State state;
    private double unit_price;
    @JsonProperty("product_id")
    private Integer product_id;
    @JsonProperty("supplier_id")
    private Integer supplier_id;




}
