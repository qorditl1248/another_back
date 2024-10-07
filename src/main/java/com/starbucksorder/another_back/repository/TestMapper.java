package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Test;
import com.starbucksorder.another_back.entity.TestMenuList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

@Mapper
public interface TestMapper {
    int save(Test test);
    Test findById(Long categoryId);
    int deleteById(Long categoryId);
    int update(Test test);
//    List<Test> findAll();
    Set<TestMenuList> findByCategoryId();
}
