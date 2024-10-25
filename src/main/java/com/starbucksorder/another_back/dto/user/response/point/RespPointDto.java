package com.starbucksorder.another_back.dto.user.response.point;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RespPointDto {

    private Long userId;
    // HACK: totalPoints -> totalPoint로 변경
    private int totalPoint;
    // private int point;

}
