package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OptionMapper {
    Option findByOptionName(String optionName);

    int save(Option option);

    int detailSave(Long optionId, Map<String, Integer> values);
    List<Option> getAll();
}
