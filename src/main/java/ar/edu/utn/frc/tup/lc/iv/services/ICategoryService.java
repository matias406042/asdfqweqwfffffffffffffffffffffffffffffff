package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import ar.edu.utn.frc.tup.lc.iv.models.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<DtoGetCategoryResponse> getCategories();

}
