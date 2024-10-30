package com.starbucksorder.another_back.dto.admin.response.category;

import com.starbucksorder.another_back.dto.user.response.menu.RespOnlyMenuIdAdnName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespAdminOneItems {
    private RespAdminCategoryDto category;
    private List<RespOnlyMenuIdAdnName> menuList;
}
