package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminCategoryDto;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminIncludeMenuByCategoryDto;
import com.starbucksorder.another_back.dto.admin.response.category.RespAdminCategoryDto;
import com.starbucksorder.another_back.dto.user.response.category.RespCategoryDto;
import com.starbucksorder.another_back.dto.user.response.menu.RespOnlyMenuIdAdnName;
import com.starbucksorder.another_back.entity.Category;
import com.starbucksorder.another_back.entity.Menu;
import com.starbucksorder.another_back.exception.DuplicateNameException;
import com.starbucksorder.another_back.repository.CategoryMapper;
import com.starbucksorder.another_back.repository.MenuCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private MenuCategoryMapper menuCategoryMapper;

    @Autowired
    private DuplicateService duplicateService;

    public RespCategoryDto getCategory() {
        List<Category> categoryList = categoryMapper.findAllByEnable();

        return RespCategoryDto.builder()
                .categories(categoryList)
                .build();

    }

    // NOTE: 관리자 카테고리 기능

    // 카테고리추가
    public Boolean add(ReqAdminCategoryDto dto) {
        // 카테고리명 중복검사
        duplicateService.isDuplicateName("category", dto.getCategoryName());

        return categoryMapper.save(dto.toEntity()) > 0;
    }

    // 해당 카테고리에 메뉴들 포함시키기
    public Boolean includeMenusByCategoryId(ReqAdminIncludeMenuByCategoryDto dto) {
        // 우선 삭제
        menuCategoryMapper.deleteByCategoryId(dto.getCategoryId());
        if (dto.getCategoryId() == null) {
            return true;
        }
        if (dto.getMenuIds() != null && dto.getMenuIds().size() > 0) {
            menuCategoryMapper.save(dto.getCategoryId(), dto.getMenuIds());
        }
        return true;
    }

    // 카테고리 삭제
    public boolean delete(Long id) {
        return categoryMapper.delete(id) > 0;
    }

    // 카테고리 수정
    public boolean update(ReqAdminCategoryDto dto) {
        try {
            categoryMapper.update(dto.toEntity());
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateNameException("Category name already exist");
        }
        return true;
    }

    // 카테고리 상태수정
    public void updateStatus(Long categoryId) {
        categoryMapper.updateStatus(categoryId);
    }

    // 카테고리 전체조회
    public List<RespAdminCategoryDto> getAllCategories() {
        return categoryMapper.FindAll().stream().map(Category::toCategories).collect(Collectors.toList());
    }

    // 카테고리 단건조회
    public List<RespOnlyMenuIdAdnName> getCategoryById(Long categoryId) {
        return menuCategoryMapper.findAllByCategoryId(categoryId).stream().map(Menu::toRespOnlyIdAndNameDto).collect(Collectors.toList());
    }

}
