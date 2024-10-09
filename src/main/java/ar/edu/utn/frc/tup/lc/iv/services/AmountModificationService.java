package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.ammountModification.request.DecrementModificationRequestDto;
import org.springframework.http.ResponseEntity;

public interface AmountModificationService {

    ResponseEntity<String> giveLogicalLow(DecrementModificationRequestDto d) ;




}
