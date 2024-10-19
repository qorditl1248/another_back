package com.starbucksorder.another_back.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDetailMapper {
    int save(Long menuId, List<Long> optionIds);
}
