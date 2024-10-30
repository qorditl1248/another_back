package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Menu;
import com.starbucksorder.another_back.entity.Option;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OptionMapper {
    // 중복검사를 위한 것
    Option findByOptionName(String optionName);

    // 옵션 이름 추가
    int save(Option option);

    // 부가옵션 추가
    int detailSave(Long optionId, Map<String, Integer> values);

    // 전체 불러오기
    List<Option> getAll();

    // 옵션 아이디에 해당하는 정보 불러오기 (디테일까지)
    Option findByOptionId(Long optionId);

    // 옵션아이디에 해당하는 메뉴 전체 불러오기
    List<Menu> getAllByOptionId(List<Long> optionIds);

    // 옵션 삭제
    int deleteByOptionId(Long optionId);

    int updateStatus(Long optionId);
}
