package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CreateProductDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.ProductXDetailDTO;
import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;
import ar.edu.utn.frc.tup.lc.iv.models.State;
import ar.edu.utn.frc.tup.lc.iv.repositories.DetailProductRepository;
import ar.edu.utn.frc.tup.lc.iv.repositories.ProductRepository;
import ar.edu.utn.frc.tup.lc.iv.services.DetailProductService;
import ar.edu.utn.frc.tup.lc.iv.services.ProductService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private DetailProductService detailProductService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper,
                              DetailProductService detailProductService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.detailProductService = detailProductService;
    }

    //si no existe un producto con el mismo nombre, se crea un nuevo producto junto con su detalle
    @Override
    @Transactional
    public ProductXDetailDTO createProduct(CreateProductDTO DTO) {
        ProductEntity Pentity = modelMapper.map(DTO, ProductEntity.class);
        ArrayList<ProductEntity> products =productRepository.findByName(Pentity.getName());
        if(products.size()>0){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Ya existe un producto con ese nombre");
        }
        DetailProductEntity Dentity = modelMapper.map(DTO, DetailProductEntity.class);
        Dentity.setState(State.available);
        Dentity.setProduct(Pentity);
        Dentity=detailProductService.saveDetailProduct(Dentity);
        Pentity=productRepository.save(Pentity);
        return modelMapper.map(Dentity, ProductXDetailDTO.class);
    }
}
