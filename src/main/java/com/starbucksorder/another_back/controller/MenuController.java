package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.aspect.annotation.ValidAop;
import com.starbucksorder.another_back.dto.admin.ReqAdminDeleteDto;
import com.starbucksorder.another_back.dto.admin.request.menu.ReqAdminDto;
import com.starbucksorder.another_back.dto.admin.request.menu.ReqAdminMenuListDtoAll;
import com.starbucksorder.another_back.dto.admin.request.menu.ReqAdminMenuDto;
import com.starbucksorder.another_back.dto.admin.request.menu.ReqAdminModifyDto;
import com.starbucksorder.another_back.dto.user.request.Order.ReqOrderItem;
import com.starbucksorder.another_back.dto.user.request.menu.ReqMenuListDto;
import com.starbucksorder.another_back.service.DuplicateService;
import com.starbucksorder.another_back.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private DuplicateService duplicateService;

    @GetMapping("/home/category/menus")
    @ApiOperation(value = "사용자 메뉴리스트 불러오기 12개씩")
    public ResponseEntity<?> getMenuList(ReqMenuListDto dto) {
        return ResponseEntity.ok().body(menuService.getMenuList(dto));
    }

    @GetMapping("/menu/{menuId}")
    @ApiOperation(value = "사용자 메뉴선택시 상세보기")
    public ResponseEntity<?> getMenuById(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.getMenu(menuId));
    }

    /* NOTE: --------------관리자 메뉴추가를 위한 로직-------------- */
    @GetMapping("/admin/menu/values")
    @ApiOperation(value = "메뉴추가를 하기위한 전체 옵션, 카테고리 불러오기")
    public ResponseEntity<?> getNames() {
        return ResponseEntity.ok().body(menuService.getValueAll());
    }

    @GetMapping("/admin/menu")
    @ApiOperation(value = "메뉴 전체조회 (카테고리관리, 옵션관리에서 메뉴들을 다중선택할 때 사용")
    public ResponseEntity<?> getMenuListAll() {
        return ResponseEntity.ok().body(menuService.getMenuListAll());
    }

    @GetMapping("/admin/menus")
    @ApiOperation(value = "메뉴이름 또는 카테고리에 대한 전체조회, 페이징처리 및 해당하는 전체 갯수보여주기")
    public ResponseEntity<?> getAllMenus(ReqAdminMenuDto dto) {
        System.out.println("동작됨");
        return ResponseEntity.ok().body(menuService.getAllMenus(dto));
    }

    @PostMapping("/admin/menu")
    @ApiOperation(value = "메뉴 추가")
    @ValidAop
    public ResponseEntity<?> addMenu(@RequestBody @Valid ReqAdminDto dto, BindingResult bindingResult) {
        return ResponseEntity.ok().body(menuService.addMenu(dto));
    }

    @GetMapping("/admin/menu/detail/{menuId}")
    @ApiOperation(value = "메뉴id에 대한 상세보기 (옵션, 카테고리)")
    public ResponseEntity<?> getMenuDetail(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.getMenuDetail(menuId));
    }

    @DeleteMapping("/admin/menu")
    @ApiOperation(value = "id를 리스트로 받아서 한번에 삭제")
    public ResponseEntity<?> deleteMenu(ReqAdminDeleteDto dto) {
        return ResponseEntity.ok().body(menuService.deleteMenu(dto));
    }

    @PatchMapping("/admin/modify/{menuId}")
    @ApiOperation(value = "해당id로 수정요청")
    @ValidAop
    public ResponseEntity<?> modifyMenu(@PathVariable Long menuId, @RequestBody @Valid ReqAdminModifyDto dto, BindingResult bindingResult) {
        return ResponseEntity.ok().body(menuService.modifyMenu(dto));
    }

    @PatchMapping("/admin/menu/status/{menuId}")
    @ApiOperation(value = "메뉴 활성/비활성화에 대한 상태 수정 요청")
    public ResponseEntity<?> updateMenuStatus(@PathVariable Long menuId) {
        return ResponseEntity.ok().body(menuService.updateMenuStatus(menuId));
    }

    /* NOTE: ------------------------------------------------------------ */

    @GetMapping("/product/items")
    @ApiOperation(value = "쿠폰 결제시에 적용될 메뉴들 조회")
    public ResponseEntity<?> getProductItem(ReqOrderItem dto) {
        System.out.println(dto);
        return ResponseEntity.ok().body(menuService.findByIds(dto));
    }

}
