package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.CategoryDTO;


import java.util.List;

public interface
ICategoryService {

    CategoryDTO queryCategory(CategoryDTO category);
    List<CategoryDTO> queryAllCategories();

    int insertCategory(CategoryDTO category);
    int updateCategory(CategoryDTO category);

    int deleteCategory(CategoryDTO category);
}
