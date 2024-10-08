package com.starbucksorder.another_back.dto.request.test;

import com.starbucksorder.another_back.entity.Test;
import lombok.Builder;
import lombok.Data;

public class TestDto {
    @Data
    // 테스트에대한 요청
    public static class ReqDto {
        private Long categoryId;
        private String categoryName;
        private Long status;
        private String createDate;
        private String updateDate;

        public Test toEntity() {
            return Test.builder()
                    .categoryId(categoryId)
                    .categoryName(categoryName)
                    .status(status)
                    .createDate(createDate)
                    .updateDate(updateDate)
                    .build();
        }
    }
    @Data
    @Builder
    // 테스트에 대한 응답
    public static class RespDto{
        private String categoryName;
    }
//    --------------------------------------------------------

}
