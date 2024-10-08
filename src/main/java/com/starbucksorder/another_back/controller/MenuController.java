package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    // 카테고리별 메뉴리스트
    @GetMapping("/menus")
    public ResponseEntity<?> getMenusByCategory() {
        return ResponseEntity.ok().body(menuService.getMenus());
    }

    // 메뉴id별 메뉴정보
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<?> getMenuById(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.getMenu(menuId));
    }
}
