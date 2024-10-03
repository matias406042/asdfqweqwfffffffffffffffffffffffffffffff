package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.entities.SupplierEntity;
import ar.edu.utn.frc.tup.lc.iv.repositories.SupplierRepository;
import ar.edu.utn.frc.tup.lc.iv.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
