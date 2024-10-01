package ar.edu.utn.frc.tup.lc.iv.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private String name;
    private Long healthInsurance;
    private boolean authorized;
    private Long address;
    
}
