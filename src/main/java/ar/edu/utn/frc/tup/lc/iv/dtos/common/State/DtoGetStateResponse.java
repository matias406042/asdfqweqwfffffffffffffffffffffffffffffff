package ar.edu.utn.frc.tup.lc.iv.dtos.common.State;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoGetStateResponse {
    Integer id;
    String state;
}
