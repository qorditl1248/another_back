package com.starbucksorder.another_back.controller;

import com.starbucksorder.another_back.aspect.annotation.Log;
import com.starbucksorder.another_back.dto.admin.ReqAdminDeleteDto;
import com.starbucksorder.another_back.dto.admin.request.ReqAdminUserDto;
import com.starbucksorder.another_back.dto.admin.request.user.ReqAdminSearchDto;
import com.starbucksorder.another_back.service.PointService;
import com.starbucksorder.another_back.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// HACK: 매핑명 변경 /points -> point
public class UserController {

    @Autowired
    private PointService pointService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "포인트 사용을 위한 전화번호로 조회요청")
    @GetMapping("/point/user/reward")
    public ResponseEntity<?> getRewardPoint(@RequestParam String phoneNumber) {
        return ResponseEntity.ok().body(pointService.getUserIdByPhoneNumber(phoneNumber));
    }

    // NOTE: 관리자 회원관리

    @ApiOperation(value = "사용자 등록")
    @PostMapping("/admin/user")
    public ResponseEntity<?> addUser(@RequestBody ReqAdminUserDto dto) {
        return ResponseEntity.ok().body(userService.addUser(dto));
    }

    @ApiOperation(value = "사용자 전화번호, 메모에 대한 전체 조회 페이징방식")
    @GetMapping("/admin/user")
    // 페이지번호, 검색어
    public ResponseEntity<?> getUserAll(ReqAdminSearchDto dto) {
        return ResponseEntity.ok().body(userService.getUserAll(dto));
    }

    @ApiOperation(value = "사용자id를 참조 단 건 조회 상세보기")
    @GetMapping("/admin/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @ApiOperation(value = "사용자id를 참조 회원 삭제")
    @DeleteMapping("/admin/user")
    public ResponseEntity<?> deleteUser(ReqAdminDeleteDto dto) {
        // {params: userIds:[1,2,3]}
        return ResponseEntity.ok().body(userService.deleteUserByIds(dto));
    }

    @ApiOperation(value = "사용자id를 참조 회원 수정")
    @PatchMapping("/admin/user/modify/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody ReqAdminUserDto dto) {
        return ResponseEntity.ok().body(userService.updateUser(dto));
    }
}