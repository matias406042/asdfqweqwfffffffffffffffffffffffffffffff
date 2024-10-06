package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.entities.SupplierEntity;
import ar.edu.utn.frc.tup.lc.iv.models.Supplier;
import ar.edu.utn.frc.tup.lc.iv.repositories.SupplierRepository;
import ar.edu.utn.frc.tup.lc.iv.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    public SupplierEntity saveSupplier(SupplierEntity supplierEntity){
        return supplierRepository.save(supplierEntity);
    }

    public SupplierEntity getSupplierById(Integer id){
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Supplier> getAll() {
        return supplierRepository.findAll().stream().map(supplierEntity -> new Supplier(
                supplierEntity.getSupplier_id(),supplierEntity.getName(),supplierEntity.getHealthInsurance(),
                supplierEntity.isAuthorized(),supplierEntity.getAddress(),supplierEntity.getSupplierTypeId(),supplierEntity.getDescription())).collect(Collectors.toList());


    }
}
