package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.ammountModification.request.DecrementModificationRequestDto;

import ar.edu.utn.frc.tup.lc.iv.entities.DetailProductEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.ProductEntity;

import ar.edu.utn.frc.tup.lc.iv.models.enums.DetailProductState;
import ar.edu.utn.frc.tup.lc.iv.repositories.AmountModificationJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.repositories.DetailProductJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.services.Impl.AmountModificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AmountModificationServiceImplTest {

    @Mock
    private DetailProductJpaRepository detailProductRepository;

    @SpyBean
    private AmountModificationServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void giveLogicalLow() throws Exception {
        // dto product details
        DecrementModificationRequestDto dto = new DecrementModificationRequestDto();
        dto.setJustify("ROBO");
        dto.setIds(Arrays.asList(1,2));

        ProductEntity p = new ProductEntity();
        p.setName("MARTILLO");
        p.setMinQuantityWarning(1);
        p.setDetailProducts(Arrays.asList(new DetailProductEntity()));
        DetailProductEntity d1 = new DetailProductEntity();
        d1.setId(1);
        d1.setDiscontinued(false);
        d1.setDescription("amarillo");
        d1.setState(DetailProductState.STOCKED);
        d1.setProduct(p);
        DetailProductEntity d2 = new DetailProductEntity();
        d2.setId(2);
        d2.setDiscontinued(false);
        d2.setDescription("azul");
        d2.setState(DetailProductState.STOCKED);
        d2.setProduct(p);
        DetailProductEntity d3 = new DetailProductEntity();
        d3.setId(3);
        d3.setDiscontinued(false);
        d3.setDescription("azul");
        d3.setState(DetailProductState.STOCKED);
        d3.setProduct(p);

        List<DetailProductEntity> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        p.setDetailProducts(list);



        // Mock the getActivesXIds method to return the detail products
        when(service.getActivesXIds(anyList())).thenReturn(Arrays.asList(d1,d2,d3));
        when(service.getActivesXProducto(any())).thenReturn(Arrays.asList(d1,d2,d3));
        when(detailProductRepository.findById(anyInt())).thenReturn(Optional.of(d1));
        when(detailProductRepository.findById(anyInt())).thenReturn(Optional.of(d2));


        // Act
        ResponseEntity<String> response = service.giveLogicalLow(dto);

        // Assert
        assertEquals(ResponseEntity.ok("OPERACION EXITOSA"), response);


        //  when(service.getActivesXIds(anyList())).thenReturn(p.getDetailProducts());
       // when(service.getActivesXProducto(any(ProductEntity.class))).thenReturn(Arrays.asList(d3));



    }
}