package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.user.request.menu.ReqMenuListDto;
import com.starbucksorder.another_back.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
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

    // 카테고리별 메뉴 12개씩
    @Log
    @GetMapping("/home/category/menus")
    public ResponseEntity<?> getMenuList(ReqMenuListDto dto) {
        return ResponseEntity.ok().body(menuService.getMenuList(dto));
    }

    // 메뉴id별 메뉴정보]
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<?> getMenuById(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.getMenu(menuId));
    }

}
