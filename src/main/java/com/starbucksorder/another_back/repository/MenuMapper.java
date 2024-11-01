package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Menu;
import com.starbucksorder.another_back.entity.Option;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    // 카테고리별 메뉴리스트 -> 12개씩
    List<Menu> findAllByStartIndexAndLimit(
            @Param("categoryId") Long categoryId,
            @Param("startIndex") Long startIndex,
            @Param("limit") Long limit
    );

    int getCountAllBySearch(Long categoryId);

    // 사용자 메뉴 선택시 상세보기
    Menu findByMenuId(Long menuId);

    Menu findByMenuName(@Param("menuName") String menuName);

    // 메뉴리스트 전체 조회
    List<Menu> getMenuList();

    int totalCount(@Param("searchName") String searchName);

    // 관리자 메뉴관리 검색 및 페이지로 주기
    List<Menu> getMenuListPageByName(Long startIndex, Long limit, String searchName);

    List<Option> getOptionList();


    // 메뉴 자소 분리 로직
    int updateMenuName(Long menuId, @Param("menuName") String menuName);

    // 메뉴 추가
    int save(Menu menu);

    // 메뉴수정
    int update(Menu menu);

    // FIXME: 사용자의 findbyId와 유사한 메소드명 설정
    // 관리자 메뉴 상세보기
    Menu menuDetailByMenuId(Long menuId);

    // 메뉴 삭제
    int deleteByMenuId(Long menuId);

    // 메뉴 상태 수정
    int updateMenuStatus(Long menuId);

    List<Menu> findByMenuIds(@Param("menuIds") List<Long> menuIds);


}
