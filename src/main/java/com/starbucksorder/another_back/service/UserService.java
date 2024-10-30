package com.starbucksorder.another_back.service;

import com.starbucksorder.another_back.dto.admin.request.ReqAdminUserDto;
import com.starbucksorder.another_back.dto.admin.response.user.RespAdminDto;
import com.starbucksorder.another_back.entity.User;
import com.starbucksorder.another_back.exception.DuplicateNameException;
import com.starbucksorder.another_back.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean addUser(ReqAdminUserDto dto) {
        if (userMapper.findUserByPhoneNumber(dto.getPhoneNumber()) != null) {
            throw new DuplicateNameException("phone number already exist");
        }
        return userMapper.saveUser(dto.toEntity()) > 0;
    }

    public List<RespAdminDto> getUserAll() {
        return userMapper.getUserAll().stream().map(User::toRespAdminDto).collect(Collectors.toList());
    }

    public RespAdminDto getUserById(Long userId) {
        return userMapper.findUserByUserId(userId).toRespAdminDto();
    }
}
