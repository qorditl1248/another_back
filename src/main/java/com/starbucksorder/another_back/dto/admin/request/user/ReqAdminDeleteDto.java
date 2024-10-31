package com.starbucksorder.another_back.dto.admin.request.user;


import java.util.List;

public class ReqAdminDeleteDto {
    private List<Long> userIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
