package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int save(Long menuId, List<Long> categories);

    // 상태코드 1번인 것만의 카테고리를 전부 다 가지고오는 것
    List<Category> findAllByEnable();

    // 상태코드와 상관없이 전부 다 가지고오는 것
    List<Category> FindAll();

    int deleteCategoryById(Long menuId);

    Category findByCategoryName(String categoryName);
}
