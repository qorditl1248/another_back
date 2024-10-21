package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Category;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper {
    List<Category> getCategory();

    List<Category> getCategoryAll();
}
