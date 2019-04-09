package com.superfly.cms.dao;

import com.superfly.cms.entity.MaintainTeam;


import java.util.List;

public interface MaintainTeamDao {
    /**
     * 查询所有的班组信息
     * @return
     */
    List<MaintainTeam> queryMaintainTeam();

    /**
     * 根据id查询一条故障信息
     * @param maintainTeamId
     * @return
     */
    MaintainTeam queryMaintainTeamById(int maintainTeamId);
    /**
     * 插入一条故障信息
     * @param maintainTeam
     * @return success:1 flase:0
     */
    int insertMaintainTeam(MaintainTeam maintainTeam);

    /**
     * 更新一条故障信息
     * @param maintainTeam
     * @return success:1 flase:0
     */
    int updateMaintainTeam(MaintainTeam maintainTeam);

    /**
     * 删除一条故障信息
     * @param maintainTeamId
     * @return success:1 flase:0
     */
    int deleteMaintainTeam(int maintainTeamId);
}
