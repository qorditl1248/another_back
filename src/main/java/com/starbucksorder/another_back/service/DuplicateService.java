package com.starbucksorder.another_back.service;

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
        switch (mapperName) {
            case "menu":
                return menuMapper.findByMenuName(name) != null;
            case "category":
                return categoryMapper.findByCategoryName(name) != null;
            case "optionMapper":
                return optionMapper.findByOptionName(name)!=null;
        }
        return true;
    }

}
