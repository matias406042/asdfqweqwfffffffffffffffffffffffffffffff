package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.entities.SupplierEntity;
import ar.edu.utn.frc.tup.lc.iv.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierService {
    SupplierEntity getSupplierById(Integer supplierId);

    Iterable<Supplier> getAll();
}
