package com.starbucksorder.another_back.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRoles {
    private Long userRoleId;
    private Long userId;
    private Long roleId;

    private Role role;

}
