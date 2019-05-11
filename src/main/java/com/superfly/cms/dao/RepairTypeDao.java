package com.superfly.cms.dao;

import com.superfly.cms.entity.RepairType;

import java.util.List;

public interface RepairTypeDao {
    /**
     * 查询所有的维修类别信息
     * @return
     */
    List<RepairType> queryRepairType();

    /**
     * 查询维修类别信息
     * @return
     */
    RepairType queryRepairTypeById(Integer repairTypeId);
}
