package ar.edu.utn.frc.tup.lc.iv.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Integer id;
    String name;
    Boolean reusable;
    Category category;
    Integer minQuantityWarning;
    Integer amount;
    List<DetailProduct> detailProducts;
    LocalDateTime createdDatetime;
    Integer createdUser;
    LocalDateTime lastUpdateDatetime;
    Integer lastUpdatedUser;
}
