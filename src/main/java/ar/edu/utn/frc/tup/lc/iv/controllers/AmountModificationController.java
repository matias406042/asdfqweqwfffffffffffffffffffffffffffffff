package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.ammountModification.request.DecrementModificationRequestDto;
import ar.edu.utn.frc.tup.lc.iv.services.AmountModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AmountModification")
public class AmountModificationController {


    @Autowired
    AmountModificationService service;
    @PutMapping("/Decrement")
    public ResponseEntity<String> postApuesta(@RequestBody DecrementModificationRequestDto requestDto) {

        return service.giveLogicalLow(requestDto);

    }
}
