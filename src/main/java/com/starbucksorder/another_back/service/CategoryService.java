package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.aspect.LogAspect;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminCategoryDto;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminIncludMenuByCategoryDto;
import com.starbucksorder.another_back.dto.user.response.category.RespCategoryDto;
import com.starbucksorder.another_back.entity.Category;
import com.starbucksorder.another_back.repository.CategoryMapper;
import com.starbucksorder.another_back.repository.MenuCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private MenuCategoryMapper menuCategoryMapper;

    @Autowired
    private DuplicateService duplicateService;
    @Autowired
    private LogAspect logAspect;

    public RespCategoryDto getCategory() {
        List<Category> categoryList = categoryMapper.findAllByEnable();

        return RespCategoryDto.builder()
                .categories(categoryList)
                .build();

    }

    // 카테고리추가
    public Boolean add(ReqAdminCategoryDto dto) {
        // 카테고리명 중복검사
        duplicateService.isDuplicateName("category", dto.getCategoryName());

        return categoryMapper.save(dto.toEntity()) > 0;
    }

    // 해당 카테고리에 메뉴들 포함시키기
    public Boolean includeMenusByCategoryId(ReqAdminIncludMenuByCategoryDto dto) {
        // 우선 삭제
        menuCategoryMapper.deleteByCategoryId(dto.getCategoryId());
        if (dto.getCategoryId() == null) {
            return true;
        }
        return menuCategoryMapper.save(dto.getCategoryId(), dto.getMenuIds()) > 0;
    }

    // 카테고리 삭제
    public boolean delete(Long id) {
        return categoryMapper.delete(id) > 0;
    }

    // 카테고리 수정
    public boolean update(ReqAdminCategoryDto dto) {
        return categoryMapper.update(dto.toEntity()) > 0;
    }

    // 카테고리 상태수정
    public void updateStatus(Long categoryId) {
        categoryMapper.updateStatus(categoryId);
    }


}
