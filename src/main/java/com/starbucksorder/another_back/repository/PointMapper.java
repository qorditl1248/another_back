package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.dto.request.Point.ReqPointDto;
import com.starbucksorder.another_back.entity.Point;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
//    int save(ReqPointDto dto);
    int save(Long userId, int point);
    Point getPoints(Long userId);
}
