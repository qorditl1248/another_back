package com.starbucksorder.another_back.service;


import com.starbucksorder.another_back.dto.admin.MenuDto;
import com.starbucksorder.another_back.dto.admin.request.ReqMenuListDtoAll;
import com.starbucksorder.another_back.dto.user.request.menu.ReqMenuListDto;
import com.starbucksorder.another_back.dto.user.response.menu.RespMenuDto;
import com.starbucksorder.another_back.dto.user.response.menu.RespMenuListByCategoryIdDto;
import com.starbucksorder.another_back.entity.Menu;
import com.starbucksorder.another_back.entity.MenuDetail;
import com.starbucksorder.another_back.repository.MenuDetailMapper;
import com.starbucksorder.another_back.repository.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuDetailMapper menuDetailMapper;

    // 전체 메뉴리스트 조회
    /*public RespMenuListDto getMenus() {
        ArrayList<Menu> menus = menuMapper.findAllCategoryItem();
        return RespMenuListDto.builder()
                .menuList(menus)
                .build();
    }*/
    // 카테고리별 메뉴리스트 조회 -> 쓸지말지 보류
//    public List<RespMenuListByCategoryIdDto> getMenusByCategoryId(Long categoryId) {
//
//        ArrayList<Menu> menus = menuMapper.findByCategoryId(categoryId);
//
//        List<RespMenuListByCategoryIdDto> list = menus.stream()
//                .map(menu -> new RespMenuListByCategoryIdDto(menu.getMenuId()
//                        , menu.getCategoryId()
//                        , menu.getMenuName()
//                        , menu.getMenuPrice()
//                        , menu.getImgUrl()))
//                .collect(Collectors.toList());
//
//        return list;
//    }

    //  카테고리별 메뉴리스트 종류 -> 24개씩
    public RespMenuListByCategoryIdDto getMenuList(ReqMenuListDto dto) {
        Long startIndex = (dto.getPage() - 1) * dto.getLimit();
        List<Menu> menuLists = menuMapper.findAllByStartIndexAndLimit(dto.getCategoryId(), startIndex, dto.getLimit());
        Integer menuTotalCount = menuMapper.getCountAllBySearch(dto.getCategoryId());

        return RespMenuListByCategoryIdDto.builder()
                .menus(menuLists)
                .totalCount(menuTotalCount)
                .build();

    }


    // 메뉴id 별 메뉴상세정보
    public RespMenuDto getMenu(Long menuId) {
        Menu selectedMenu = menuMapper.findByMenuId(menuId);

        List<MenuDetail> details = selectedMenu.getMenuDetails();
//        List<OptionDetail> options = selectedMenu.getMenuDetails().getOptions().getOptions();


        return RespMenuDto.builder()
                .menuId(selectedMenu.getMenuId())
                .menuName(selectedMenu.getMenuName())
                .comment(selectedMenu.getComment())
                .menuPrice(selectedMenu.getMenuPrice())
                .imgUrl(selectedMenu.getImgUrl())
                .menuDetailList(details)
                .build();
    }

    // 관리자 관련

    // 메뉴 이름 조회
    public boolean validMenuName(String menuName) {
        return menuMapper.findByMenuName(menuName);
    }
    // 메뉴 추가
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean addMenu(MenuDto.ReqDto dto) {
        Menu menu = dto.toMenuEntity();
        menuMapper.save(menu);
        // 옵션 추가
        for (Long optionId : dto.getOptionIds()) {
            MenuDetail menuDetail = MenuDetail.builder()
                    .menuId(menu.getMenuId())
                    .optionId(optionId)
                    .build();
            menuDetailMapper.save(menuDetail);
        }
        return true;
    }

    // 자소분리현상 처리 로직
    @Transactional(rollbackFor = Exception.class)
    public void modifyMenu(List<ReqMenuListDtoAll> menuList) {
        for (ReqMenuListDtoAll data : menuList) {
            menuMapper.updateMenuName(data.getMenuId(), data.getMenuName());
        }
        System.out.println("완료");
    }
}
