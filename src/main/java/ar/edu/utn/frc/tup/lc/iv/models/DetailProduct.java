package ar.edu.utn.frc.tup.lc.iv.models;

import ar.edu.utn.frc.tup.lc.iv.models.enums.DetailProductState;
import ar.edu.utn.frc.tup.lc.iv.models.enums.SupplierType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.nimbus.State;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailProduct {
   private Integer id;
   private Integer productId;
   private String description;
   private ar.edu.utn.frc.tup.lc.iv.models.Supplier supplier;
   private DetailProductState state;


}
