package com.superfly.cms.dao;

import com.superfly.cms.entity.OwnRegulationsFix;

import java.util.List;

public interface OwnRegulationsFixDao {
    /**
     * 查询所有的信息
     * @return
     */
    List<OwnRegulationsFix> queryOwnRegulationsFix();

    /**
     * 通过id查询信息
     * @param ownId
     * @return
     */
    List<OwnRegulationsFix> queryOwnRegulationsFixByOwnId(Integer ownId);

    /**
     * 通过fixid查询信息
     * @param fixId
     * @return
     */
    List<OwnRegulationsFix> queryOwnRegulationsFixByFixId(Integer fixId);

    /**
     * 插入一条信息
     * @param ownRegulationsFix
     * @return success:1 flase:0
     */
    int insertOwnRegulationsFix(OwnRegulationsFix ownRegulationsFix);

    /**
     * 更改信息
     * @param ownRegulationsFix
     * @return success:1 flase:0
     */
    int updateOwnRegulationsFix(OwnRegulationsFix ownRegulationsFix);

    /**
     * 通过id删除拥有信息
     * @param ownId
     * @return
     */
    int deleteOwnRegulationsFix(Integer ownId);
}
