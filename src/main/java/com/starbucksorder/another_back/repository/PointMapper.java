package com.starbucksorder.another_back.repository;

import com.starbucksorder.another_back.entity.Point;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
//    int save(ReqPointDto dto);
    int save(Long userId, int point);
    // HACK: getPoints -> getPoint로 변경
    Point getPoints(Long userId);
    int usePoints(Long userId, int point);
}
