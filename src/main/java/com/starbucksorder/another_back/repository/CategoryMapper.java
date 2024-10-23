package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int save(Long menuId, List<Long> categories);
    // FIXME: findAllByEnable
    List<Category> getCategory();
    // FIXME: FindAll
    List<Category> getCategoryAll();

    int deleteCategoryById(Long menuId);
    Category findByCategoryName(String categoryName);
}
