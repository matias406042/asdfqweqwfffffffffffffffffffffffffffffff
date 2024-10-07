package ar.edu.utn.frc.tup.lc.iv.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {
    Integer id;
    String state;
    LocalDateTime createdDatetime;
    Integer createdUser;
    LocalDateTime lastUpdateDatetime;
    Integer lastUpdatedUser;
}
