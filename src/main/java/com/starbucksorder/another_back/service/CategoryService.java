package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.response.category.RespCategoryDto;
import com.starbucksorder.another_back.entity.Category;
import com.starbucksorder.another_back.repository.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public RespCategoryDto getCategory() {
        List<Category> categoryList = categoryMapper.getCategory();

        return RespCategoryDto.builder()
                .categories(categoryList)
                .build();

    }

}
