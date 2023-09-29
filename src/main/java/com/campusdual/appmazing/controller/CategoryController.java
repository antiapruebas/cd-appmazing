package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.ICategoryService;
import com.campusdual.appmazing.model.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String testController() {
        return "Category controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Category controller works " + name + "!";
    }

    @GetMapping (value="/testMethod")
    public String testControllerMethod() {
        return  "Category controller method works!";
    }

    @PostMapping(value="/get")
    public CategoryDTO queryCategory (@RequestBody CategoryDTO category){
        return this.categoryService.queryCategory(category);
    }

    @GetMapping (value="/getAll")
    public List<CategoryDTO> queryAllCategories() {
        return this.categoryService.queryAllCategories();
    }

    @PostMapping (value="/add")
    public int insertContact (@RequestBody CategoryDTO category) {
        return this.categoryService.insertCategory(category);
    }
    @PutMapping(value="/update")
    public int updateContact (@RequestBody CategoryDTO category) {
        return this.categoryService.updateCategory(category);
    }
    @DeleteMapping(value="/delete")
    public int deleteContact (@RequestBody CategoryDTO category) {
        return this.categoryService.deleteCategory(category);
    }
}
