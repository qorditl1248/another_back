package com.starbucksorder.another_back.dto.admin.request.category;

import com.starbucksorder.another_back.entity.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReqAdminCategoryDto {
    private Long categoryId;
    @NotBlank(message = "빈값일 수 없습니다")
    private String categoryName;
    private Long categoryStatus;
    private int categorySeq;

    public Category toEntity() {
        return Category.builder()
                .categoryId(categoryId)
                .categoryName(categoryName)
                .categoryStatus(categoryStatus)
                .categorySeq(categorySeq)
                .build();
    }
}