package com.starbucksorder.another_back.dto.response.test;

import com.starbucksorder.another_back.entity.Test;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RespTestListDto {
        List<Test> testList;
}
