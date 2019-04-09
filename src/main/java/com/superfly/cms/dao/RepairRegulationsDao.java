package com.superfly.cms.dao;

import com.superfly.cms.entity.RepairRegulations;

import java.util.List;

public interface RepairRegulationsDao {
    /**
     * 查询所有的维修信息
     * @return
     */
    List<RepairRegulations> queryRepairRegulations();

    /**
     * 根据id查询一条故障信息
     * @param repairId
     * @return
     */
    RepairRegulations queryRepairRegulationsById(int repairId);
    /**
     * 插入一条故障信息
     * @param repairRegulations
     * @return success:1 flase:0
     */
    int insertRepairRegulations(RepairRegulations repairRegulations);

    /**
     * 更新一条故障信息
     * @param repairRegulations
     * @return success:1 flase:0
     */
    int updateRepairRegulations(RepairRegulations repairRegulations);

    /**
     * 删除一条故障信息
     * @param repairId
     * @return success:1 flase:0
     */
    int deleteRepairRegulations(int repairId);
}
