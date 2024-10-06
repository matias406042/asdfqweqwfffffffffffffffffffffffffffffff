package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;

import java.util.List;

public interface DetailProductService {
    DetailProductEntity saveDetailProduct(DetailProductEntity detailProductEntity);

    List<DetailProductEntity> saveAll(List<DetailProductEntity> dentities);
}
