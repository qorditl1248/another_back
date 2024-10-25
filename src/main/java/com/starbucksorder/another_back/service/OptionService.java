package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.option.ReqAdminOptionDto;
import com.starbucksorder.another_back.repository.OptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {
    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private DuplicateService duplicateService;

    public boolean add(ReqAdminOptionDto dto) {
        duplicateService.isDuplicateName("option", dto.getOptionName());
        if (optionMapper.save(dto.toEntity()) > 0) {

        }
        return true;
    }
}
