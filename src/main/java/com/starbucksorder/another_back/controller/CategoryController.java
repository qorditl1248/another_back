package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminCategoryDto;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminIncludeMenuByCategoryDto;
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
    public ResponseEntity<?> includeMenu(@RequestBody ReqAdminIncludeMenuByCategoryDto dto) {
        return ResponseEntity.ok().body(categoryService.includeMenusByCategoryId(dto));
    }

    // 카테고리 조회
    @GetMapping("/admin/category")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    // 카테고리 단 건 조회
    @GetMapping("/admin/category/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(categoryId));
    }

    // 카테고리 삭제
    @DeleteMapping("/admin/category/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(categoryService.delete(categoryId));
    }

    // 카테고리 수정
    @PatchMapping("/admin/category/{categoryId}")
    public ResponseEntity<?> update(@PathVariable Long categoryId, @RequestBody ReqAdminCategoryDto dto) {
        return ResponseEntity.ok().body(categoryService.update(dto));
    }

    // 카테고리 상태 수정
    @PatchMapping("/admin/category/status/{categoryId}")
    public ResponseEntity<?> updateStatus(@PathVariable Long categoryId) {
        categoryService.updateStatus(categoryId);
        return ResponseEntity.ok().body(true);
    }
}