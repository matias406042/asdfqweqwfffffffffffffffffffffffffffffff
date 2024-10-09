package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.services.ICategoryService;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import ar.edu.utn.frc.tup.lc.iv.entities.CategoryEntity;
import ar.edu.utn.frc.tup.lc.iv.repositories.CategoryJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryJpaRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

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
