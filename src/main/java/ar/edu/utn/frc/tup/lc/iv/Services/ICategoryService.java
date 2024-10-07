package ar.edu.utn.frc.tup.lc.iv.Services;

import ar.edu.utn.frc.tup.lc.iv.Entities.CategoryEntity;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<DtoGetCategoryResponse> getCategories();
}
