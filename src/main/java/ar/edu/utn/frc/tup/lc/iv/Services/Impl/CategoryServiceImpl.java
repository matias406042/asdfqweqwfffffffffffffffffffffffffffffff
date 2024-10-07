package ar.edu.utn.frc.tup.lc.iv.Services.Impl;

import ar.edu.utn.frc.tup.lc.iv.Services.ICategoryService;
import ar.edu.utn.frc.tup.lc.iv.Entities.CategoryEntity;
import ar.edu.utn.frc.tup.lc.iv.Repositories.CategoryJpaRepository;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryJpaRepository categoryRepository;

    public void get(){

    }

    @Override
    public List<DtoGetCategoryResponse> getCategories() {
        List<CategoryEntity> dataList = categoryRepository.findAll();
        List<DtoGetCategoryResponse> listCategories = new ArrayList<>();

        if (dataList.isEmpty()) return null;
        for (CategoryEntity entity : dataList) { listCategories.add(new DtoGetCategoryResponse(entity.getId(), entity.getCategory())); }

        return listCategories;
    }
}
