package com.superfly.cms.dao;

import com.superfly.cms.entity.OtherMaintain;

import java.util.List;

public interface OtherMaintainDao {
    /**
     * 查询所有的其它费用信息
     * @return
     */
    List<OtherMaintain> queryOtherMaintain();

    /**
     * 根据id查询一条故障信息
     * @param otherMaintainId
     * @return
     */
    OtherMaintain queryOtherMaintainById(Integer otherMaintainId);
    /**
     * 插入一条故障信息
     * @param otherMaintain
     * @return success:1 flase:0
     */
    int insertOtherMaintain(OtherMaintain otherMaintain);

    /**
     * 更新一条故障信息
     * @param otherMaintain
     * @return success:1 flase:0
     */
    int updateOtherMaintain(OtherMaintain otherMaintain);

    /**
     * 删除一条故障信息
     * @param otherMaintainId
     * @return success:1 flase:0
     */
    int deleteOtherMaintain(Integer otherMaintainId);


}
