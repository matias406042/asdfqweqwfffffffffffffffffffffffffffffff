package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CreateProductDTO;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.ProductXDetailDTO;
import ar.edu.utn.frc.tup.lc.iv.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService miServicio;

    @Test
    void createProduct() throws Exception {
        given(miServicio.createProduct(any(CreateProductDTO.class))).willReturn(new ProductXDetailDTO());

        mockMvc.perform(post("/product")
                .contentType("application/json")
                .content("{\"name\":\"test\",\"reusable\":true,\"min_amount_warning\":1,\"amount\":1,\"description\":\"test\",\"unit_price\":1.0,\"supplier_id\":1,\"category_id\":1}"))
                .andExpect(status().isOk());

    }

}