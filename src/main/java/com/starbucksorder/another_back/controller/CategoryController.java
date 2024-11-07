package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.dto.admin.ReqAdminDeleteDto;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminCategoryDto;
import com.starbucksorder.another_back.dto.admin.request.category.ReqAdminIncludeMenuByCategoryDto;
import com.starbucksorder.another_back.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // 전체 카테고리 조회
    @ApiOperation(value = "전체카테고리조회")
    @GetMapping("/category")
    public ResponseEntity<?> getCategory() {
        return ResponseEntity.ok().body(categoryService.getCategory());
    }


    /* NOTE: ---------------------------------ADMIN 관련----------------------------------------*/

    @ApiOperation(value = "카테고리 등록")
    @PostMapping("/admin/category")
    public ResponseEntity<?> add(@RequestBody ReqAdminCategoryDto dto) {
        return ResponseEntity.ok().body(categoryService.add(dto));
    }

    @ApiOperation(value = "메뉴에 해당 카테고리 부여하기")
    @PostMapping("/admin/category/menu")
    public ResponseEntity<?> includeMenu(@RequestBody ReqAdminIncludeMenuByCategoryDto dto) {
        return ResponseEntity.ok().body(categoryService.includeMenusByCategoryId(dto));
    }

    @ApiOperation(value = "카테고리 전체조회")
    @GetMapping("/admin/category")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @ApiOperation(value = "카테고리 id로 상세보기 및 해당 메뉴 불러오기")
    @GetMapping("/admin/category/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(categoryId));
    }


    @ApiOperation(value = "해당id로 카테고리 삭제하기 프로시저로인한 연쇄삭제")
    @DeleteMapping("/admin/category/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable Long categoryId) {
        return ResponseEntity.ok().body(categoryService.delete(categoryId));
    }

    @ApiOperation(value = "해당id로 카테고리 수정")
    @PatchMapping("/admin/category/{categoryId}")
    public ResponseEntity<?> update(@PathVariable Long categoryId, @RequestBody ReqAdminCategoryDto dto) {
        return ResponseEntity.ok().body(categoryService.update(dto));
    }

    @ApiOperation(value = "카테고리id로 활성/비활성화 수정요청")
    @PatchMapping("/admin/category/status/{categoryId}")
    public ResponseEntity<?> updateStatus(@PathVariable Long categoryId) {
        categoryService.updateStatus(categoryId);
        return ResponseEntity.ok().body(true);
    }
}