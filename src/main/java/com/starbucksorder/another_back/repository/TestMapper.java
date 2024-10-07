package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    int save(Test test);
}
