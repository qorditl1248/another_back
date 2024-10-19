package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.MenuDetail;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface MenuDetailMapper {
    int save(MenuDetail menuDetail);
}
