package com.starbucksorder.another_back.service;


import com.starbucksorder.another_back.dto.response.menu.RespMenuDto;
import com.starbucksorder.another_back.dto.response.menu.RespMenuListDto;
import com.starbucksorder.another_back.entity.Menu;
import com.starbucksorder.another_back.repository.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    // 카테고리별 메뉴리스트 조회
    public RespMenuListDto getMenus() {
        ArrayList<Menu> menus = menuMapper.findByCategoryId();

        return RespMenuListDto.builder()
                .menuList(menus)
                .build();
    }

    // 메뉴id 별 메뉴정보
    public RespMenuDto getMenu(Long menuId) {
        Set<Menu> menu = menuMapper.findByMenuId(menuId);

        return RespMenuDto.builder()
                .menu(menu)
                .build();
    }
}
