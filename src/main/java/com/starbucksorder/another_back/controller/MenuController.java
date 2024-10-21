package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.admin.MenuDto;
import com.starbucksorder.another_back.dto.admin.request.ReqMenuListDtoAll;
import com.starbucksorder.another_back.dto.user.request.menu.ReqMenuListDto;
import com.starbucksorder.another_back.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    // 전체 메뉴리스트
//    @GetMapping("/menus")
//    public ResponseEntity<?> getMenusByCategory() {
////        return ResponseEntity.ok().body(menuService.getMenus());
//        return null;
//    }


    // 카테고리별 메뉴리스트 종류 -> 그냥 다 들고옴
//    @GetMapping("/menu/category/{categoryId}")
//    public ResponseEntity<?> getMenusByCategoryId(@PathVariable Long categoryId) {
//        return ResponseEntity.ok().body(menuService.getMenusByCategoryId(categoryId));
//    }


    // 카테고리별 메뉴리스트 종류 -> 12개씩
    @Log
    @GetMapping("/home/category/menus")
    public ResponseEntity<?> getMenuList(ReqMenuListDto dto) {
        return ResponseEntity.ok().body(menuService.getMenuList(dto));
    }

    // 메뉴id별 메뉴정보
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<?> getMenuById(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.getMenu(menuId));
    }

    // 메뉴추가를 위한 로직

    // 메뉴 이름 조회 -> 단 건 조회
    @Log
    @GetMapping("/admin/menu")
    public ResponseEntity<?> validMenuName(@RequestParam String menuName) {
        return ResponseEntity.ok().body(menuService.validMenuName(menuName));
    }
    // 메뉴관리 조회 -> 다 건 조회
    @Log
    @GetMapping("/admin/menus")
    public ResponseEntity<?> getAllMenus(MenuDto.pageDto dto) {
        return ResponseEntity.ok().body(menuService.getAllMenus(dto));
    }
    // 메뉴,카테고리 검색
    @GetMapping("/admin/menu/search")
    public ResponseEntity<?> getAllMenus(String menuName) {
        return ResponseEntity.ok().body(menuService.searchMenus(menuName));
    }

    // 메뉴 추가
    @PostMapping("/admin/menu")
    public ResponseEntity<?> addMenu(@RequestBody MenuDto.ReqDto dto) {
        return ResponseEntity.ok().body(menuService.addMenu(dto));
    }

    // 메뉴 삭제
    @DeleteMapping("/admin/menu/{menuId}")
    public ResponseEntity<?> deleteMenu(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.deleteMenu(menuId));
    }
    // 메뉴 상태변경
    @PatchMapping("/admin/menu/status/{menuId}")
    public ResponseEntity<?> updateMenuStatus(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.updateMenuStatus(menuId));
    }

    // 자소분리현상 로직
    @PatchMapping("/admin/modify")
    public ResponseEntity<?> modifyMenu(@RequestBody List<ReqMenuListDtoAll> menuList) {
        menuService.modifyMenu(menuList);
            return ResponseEntity.ok().body(null);
    }

}
