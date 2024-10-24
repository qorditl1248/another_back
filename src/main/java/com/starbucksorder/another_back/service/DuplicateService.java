package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.exception.DuplicateNameException;
import com.starbucksorder.another_back.repository.CategoryMapper;
import com.starbucksorder.another_back.repository.MenuMapper;
import com.starbucksorder.another_back.repository.OptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuplicateService {
    @Autowired
    private OptionMapper optionMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private CategoryMapper categoryMapper;

    public boolean isDuplicateName(String mapperName, String name) {
        boolean isDuplicate;
        switch (mapperName) {
            case "menu":
                isDuplicate = menuMapper.findByMenuName(name) != null;
                break;
            case "category":
                isDuplicate = categoryMapper.findByCategoryName(name) != null;
                break;
            case "optionMapper":
                isDuplicate = optionMapper.findByOptionName(name) != null;
                break;
            default:
                throw new IllegalArgumentException("Invalid mapper name");
        }
        if (isDuplicate) {
            throw new DuplicateNameException(name + " is Duplicate By " + mapperName );
        }
        return true;
    }
}
