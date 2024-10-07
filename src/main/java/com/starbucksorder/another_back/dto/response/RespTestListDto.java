package com.starbucksorder.another_back.dto.response;

import com.starbucksorder.another_back.entity.TestMenuList;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class RespTestListDto {
    //    List<Test> testList;
    Set<TestMenuList> menuList;

}
