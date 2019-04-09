package com.superfly.cms.dao;

import com.superfly.cms.entity.RepairTeam;

import java.util.List;

public interface RepairTeamDao {
    /**
     * 查询所有的班组信息
     * @return
     */
    List<RepairTeam> queryRepairTeam();

    /**
     * 根据id查询一条故障信息
     * @param repairTeamId
     * @return
     */
    RepairTeam queryRepairTeamById(int repairTeamId);
    /**
     * 插入一条故障信息
     * @param repairTeam
     * @return success:1 flase:0
     */
    int insertRepairTeam(RepairTeam repairTeam);

    /**
     * 更新一条故障信息
     * @param repairTeam
     * @return success:1 flase:0
     */
    int updateRepairTeam(RepairTeam repairTeam);

    /**
     * 删除一条故障信息
     * @param repairTeamId
     * @return success:1 flase:0
     */
    int deleteRepairTeam(int repairTeamId);
}
