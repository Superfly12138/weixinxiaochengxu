package com.superfly.cms.dao;

import com.superfly.cms.entity.OtherCost;

import java.util.List;

public interface OtherCostDao {
    /**
     * 查询所有的其它费用信息
     * @return
     */
    List<OtherCost> queryOtherCost();

    /**
     * 根据id查询一条故障信息
     * @param otherCostId
     * @return
     */
    OtherCost queryOtherCostById(Integer otherCostId);
    /**
     * 插入一条故障信息
     * @param otherCost
     * @return success:1 flase:0
     */
    int insertOtherCost(OtherCost otherCost);

    /**
     * 更新一条故障信息
     * @param otherCost
     * @return success:1 flase:0
     */
    int updateOtherCost(OtherCost otherCost);

    /**
     * 删除一条故障信息
     * @param otherCostId
     * @return success:1 flase:0
     */
    int deleteOtherCost(Integer otherCostId);


}
