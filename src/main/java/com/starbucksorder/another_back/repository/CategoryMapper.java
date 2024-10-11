package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> getCategory();
}
