package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.services.ICategoryService;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.Category.DtoGetCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Qualifier("categoryServiceImpl")
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<DtoGetCategoryResponse>> getCategories(){
        List<DtoGetCategoryResponse> categories = categoryService.getCategories();

        if (Objects.isNull(categories)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The are not categories loaded");
        else return ResponseEntity.ok(categories);
    }
}
