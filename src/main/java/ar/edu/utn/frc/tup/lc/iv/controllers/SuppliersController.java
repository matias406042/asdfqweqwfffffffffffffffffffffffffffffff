package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.models.Supplier;
import ar.edu.utn.frc.tup.lc.iv.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    private SupplierService service;
    public SuppliersController(SupplierService service) {
        this.service = service;
    }
    @GetMapping("")
    public ResponseEntity<Iterable<Supplier>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
