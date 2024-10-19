package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.admin.request.ReqMenuListDtoAll;
import com.starbucksorder.another_back.dto.user.request.menu.ReqMenuListDto;
import com.starbucksorder.another_back.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    public ResponseEntity<?> getMenuByName(@RequestParam String menuName) {

        return ResponseEntity.ok().body(menuService.getMenuByName(menuName));
    }

    @GetMapping("/admin/menu/all")
    public ResponseEntity<?> getAllMenu() {

        return ResponseEntity.ok().body(menuService.getMenuList());
    }

    @PatchMapping("/admin/modify")
    public ResponseEntity<?> modifyMenu(@RequestBody List<ReqMenuListDtoAll> menuList) {
        menuService.modifyMenu(menuList);
        return ResponseEntity.ok().body(null);
    }


}
