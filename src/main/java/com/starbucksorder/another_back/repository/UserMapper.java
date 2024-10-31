package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User findUserByPhoneNumber(String phoneNumber);

    User findUserByUserId(Long userId);

    int saveUser(User user);

    int update(User user);

    void updateStar();

    List<User> getUserAll(@Param("searchName") String searchName, @Param("startIndex") Long startIndex);

    int count(String searchName);

}
