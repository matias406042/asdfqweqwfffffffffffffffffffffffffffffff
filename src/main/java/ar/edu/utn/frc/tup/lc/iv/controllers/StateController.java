package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.Services.IStateService;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.State.DtoGetStateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/State")
public class StateController {


    @Qualifier("stateServiceImpl")
    @Autowired
    private IStateService stateService;

    @GetMapping("/getAll")
    public ResponseEntity getStates() {
        List<DtoGetStateResponse> states = stateService.getStates();

        if (Objects.isNull(states)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The are not categories loaded");
        else return ResponseEntity.ok(states);
    }
}
