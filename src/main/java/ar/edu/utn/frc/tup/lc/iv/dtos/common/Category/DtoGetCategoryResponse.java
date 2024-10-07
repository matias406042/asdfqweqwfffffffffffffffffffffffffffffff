package ar.edu.utn.frc.tup.lc.iv.dtos.common.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoGetCategoryResponse {
    Integer id;
    String category;
}
