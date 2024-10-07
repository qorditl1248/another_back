package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.request.ReqTestDto;
import com.starbucksorder.another_back.repository.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public void save(ReqTestDto dto) {
        testMapper.save(dto.toEntity());

    }
}
