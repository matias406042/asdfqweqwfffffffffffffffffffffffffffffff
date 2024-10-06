package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.repositories.DetailProductRepository;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.DetailProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailProductServiceImpl implements DetailProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DetailProductRepository detailProductRepository;
    public DetailProductServiceImpl(DetailProductRepository detailProductRepository, ModelMapper modelMapper) {
        this.detailProductRepository = detailProductRepository;
        this.modelMapper = modelMapper;
    }

    public DetailProductEntity saveDetailProduct(DetailProductEntity detailProductEntity) {
        return detailProductRepository.save(detailProductEntity);
    }

    @Override
    public List<DetailProductEntity> saveAll(List<DetailProductEntity> dentities) {
        return detailProductRepository.saveAll(dentities);
    }
}
