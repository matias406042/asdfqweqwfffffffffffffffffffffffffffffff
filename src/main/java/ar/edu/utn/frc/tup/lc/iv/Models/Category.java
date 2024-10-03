package ar.edu.utn.frc.tup.lc.iv.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {
    Integer id;
    String category;
    LocalDateTime createdDatetime;
    Integer createdUser;
    LocalDateTime lastUpdateDatetime;
    Integer lastUpdatedUser;
}
