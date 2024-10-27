package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.admin.request.option.ReqAdminOptionDto;
import com.starbucksorder.another_back.dto.admin.response.option.RespAdminOptionDto;
import com.starbucksorder.another_back.entity.Option;
import com.starbucksorder.another_back.repository.OptionMapper;
import io.jsonwebtoken.impl.lang.OptionalMethodInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OptionService {
    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private DuplicateService duplicateService;

    @Transactional(rollbackFor = SQLException.class)
    public boolean add(ReqAdminOptionDto dto) {
        // 중복검사
        duplicateService.isDuplicateName("option", dto.getOptionName());
        Option option = dto.toEntity();

        try {
            optionMapper.save(option);
            optionMapper.detailSave(option.getOptionId(), dto.getValue());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("데이터베이스 요청 오류" + e.getMessage());
        }
        return true;
    }

    public List<RespAdminOptionDto> getAll() {
        return optionMapper.getAll().stream().map(Option::toOptionAllDto).collect(Collectors.toList());
    }
}
