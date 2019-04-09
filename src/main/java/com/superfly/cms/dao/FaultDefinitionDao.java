package com.superfly.cms.dao;

import com.superfly.cms.entity.FaultDefinition;

import java.util.List;

public interface FaultDefinitionDao {
    /**
     * 查询所有的故障信息
     * @return
     */
    List<FaultDefinition> queryFaultDefinition();

    /**
     * 根据id查询一条故障信息
     * @param faultId
     * @return
     */
    FaultDefinition queryFaultDefinitionById(int faultId);
    /**
     * 插入一条故障信息
     * @param faultDefinition
     * @return success:1 flase:0
     */
    int insertFaultDefinition(FaultDefinition faultDefinition);

    /**
     * 更新一条故障信息
     * @param faultDefinition
     * @return success:1 flase:0
     */
    int updateFaultDefinition(FaultDefinition faultDefinition);

    /**
     * 删除一条故障信息
     * @param faultId
     * @return success:1 flase:0
     */
    int deleteFaultDefinition(int faultId);

}
