package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.models.DetailProduct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IDetailProductService {
  //  List<DetailProduct> getDetailByProductId(Integer id); //todo agus

    List<DetailProduct> getDetailProducts();
}
