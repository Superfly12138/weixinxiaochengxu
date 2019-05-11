package com.superfly.cms.dao;

import com.superfly.cms.entity.Fix;

import java.util.List;

public interface FixDao {
    /**
     * 查询所有的维修信息
     * @return
     */
    List<Fix> queryFix();

    /**
     * 通过维修id查询维修信息
     * @param fixId
     * @return
     */
    Fix queryFixByFixId(Integer fixId);



    /**
     * 插入一条拥有信息
     * @param fix
     * @return success:1 flase:0
     */
    int insertFix(Fix fix);

    /**
     * 更改维修信息
     * @param fix
     * @return success:1 flase:0
     */
    int updateFix(Fix fix);

    /**
     * 通过id删除维修信息
     * @param fixId
     * @return
     */
    int deleteFix(Integer fixId);
}
