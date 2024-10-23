package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int save(Long menuId, List<Long> categories);

    List<Category> getCategory();

    List<Category> getCategoryAll();

    int deleteCategoryById(Long menuId);
}
