package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminCategoryDto;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminIncludMenuByCategoryDto;
import com.starbucksorder.another_back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 전체 카테고리 조회
    @GetMapping("/category")
    public ResponseEntity<?> getCategory() {
        return ResponseEntity.ok().body(categoryService.getCategory());
    }


    /* NOTE: ---------------------------------ADMIN 관련----------------------------------------*/

    // 등록
    @PostMapping("/admin/category")
    public ResponseEntity<?> add(@RequestBody ReqAdminCategoryDto dto) {
        return ResponseEntity.ok().body(categoryService.add(dto));
    }


    // 메뉴에 해당 카테고리 부여하기
    @PostMapping("/admin/category/menu")
    public ResponseEntity<?> includeMenu(@RequestBody ReqAdminIncludMenuByCategoryDto dto) {

        return ResponseEntity.ok().body(categoryService.includMenusByCategoryId(dto));
    }


}