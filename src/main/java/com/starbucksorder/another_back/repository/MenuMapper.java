package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mapper
public interface MenuMapper {
    ArrayList<Menu> findByCategoryId();
    Set<Menu> findByMenuId(Long menuId);
}
