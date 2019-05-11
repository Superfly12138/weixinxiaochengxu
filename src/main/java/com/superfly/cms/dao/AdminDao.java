package com.superfly.cms.dao;

import com.superfly.cms.entity.Admin;

public interface AdminDao {
    /**
     * 通过名字查询管理员
     * @param adminName
     * @return
     */
    Admin queryAdminByName(String adminName);
}
