package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Option;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper {
    Option findByOptionName(String name);
}
