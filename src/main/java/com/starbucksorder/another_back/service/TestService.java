package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.request.test.TestDto;
import com.starbucksorder.another_back.dto.response.test.RespTestDto;
import com.starbucksorder.another_back.dto.response.test.RespTestListDto;
import com.starbucksorder.another_back.entity.Test;
import com.starbucksorder.another_back.repository.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    // 등록
    public void save(TestDto.ReqDto dto) {
        testMapper.save(dto.toEntity());
    }

    // 단건 조회
    public RespTestDto get(Long categoryId) {
        Test test = testMapper.findById(categoryId);

        return RespTestDto.builder()
                .categoryId(test.getCategoryId())
                .categoryName(test.getCategoryName())
                .status(test.getStatus())
                .createDate(test.getCreateDate())
                .updateDate(test.getUpdateDate())
                .build();
    }

    // 다건 조회
    public RespTestListDto getAll() {
        List<Test> tests = testMapper.findAll();

        return RespTestListDto.builder()
                .testList(tests)
                .build();
    }

    // 삭제
    public void delete(Long categoryId) {
        testMapper.deleteById(categoryId);
    }

    // 수정
    public void update(TestDto.ReqDto dto) {
        System.out.println("확인222" + dto);
        testMapper.update(dto.toEntity());
    }
}
