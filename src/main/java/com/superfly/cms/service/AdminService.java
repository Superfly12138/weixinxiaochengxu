package com.superfly.cms.service;

import com.superfly.cms.entity.RepairType;

import java.util.List;

public interface AdminService {
    /**
     * 通过姓名登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    boolean loginAdminByName(String adminName,String adminPassword);

    /**
     * 获取所有的维修列表
     * @return
     */
    List<RepairType> getRepairTypeList();

    /**
     * 通过维修类别Id获取维修类别信息
     * @param repairTypeId
     * @return
     */
    RepairType getRepairTypeById(Integer repairTypeId);
}
