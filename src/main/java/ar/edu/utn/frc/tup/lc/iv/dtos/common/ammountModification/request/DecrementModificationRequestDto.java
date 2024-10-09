package ar.edu.utn.frc.tup.lc.iv.dtos.common.ammountModification.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class DecrementModificationRequestDto {
    private String justify ;
    @NotNull(message = "Ids list missing")
    @Size(min = 1, message = "The ids list cannot be empty")
    private List<Integer> ids;
}
