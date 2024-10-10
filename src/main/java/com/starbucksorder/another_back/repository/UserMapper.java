package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.dto.request.Point.ReqPointDto;
import com.starbucksorder.another_back.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findUserByPhoneNumber(String phoneNumber);
    int saveUser(ReqPointDto dto);
}
