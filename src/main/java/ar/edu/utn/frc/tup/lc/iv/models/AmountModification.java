package ar.edu.utn.frc.tup.lc.iv.models;

import ar.edu.utn.frc.tup.lc.iv.entities.SupplierEntity;
import ar.edu.utn.frc.tup.lc.iv.models.enums.AmountModificationType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
public class AmountModification {

    private Long id;
    private Integer amount;
    private ar.edu.utn.frc.tup.lc.iv.models.Product product;
    private ar.edu.utn.frc.tup.lc.iv.models.Supplier supplier;
    private String description;
    private Date date;
    private AmountModificationType modificationType;

}
