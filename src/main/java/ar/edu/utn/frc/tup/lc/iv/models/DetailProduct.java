package ar.edu.utn.frc.tup.lc.iv.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailProduct {
    Integer id;
    Integer productId;
    String description;
    Integer supplierId;
    State state;
    LocalDateTime createdDatetime;
    Integer createdUser;
    LocalDateTime lastUpdateDatetime;
    Integer lastUpdatedUser;
}
