package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    // signin
    Admin findByUserName(String username);
}
