package com.superfly.cms.dao;

import com.superfly.cms.entity.OwnMaterialFix;

import java.util.List;

public interface OwnMaterialFixDao {
    /**
     * 查询所有的信息
     * @return
     */
    List<OwnMaterialFix> queryOwnMaterialFix();

    /**
     * 通过id查询信息
     * @param ownId
     * @return
     */
    List<OwnMaterialFix> queryOwnMaterialFixByOwnId(Integer ownId);

    /**
     * 通过fixid查询信息
     * @param fixId
     * @return
     */
    List<OwnMaterialFix> queryOwnMaterialFixByFixId(Integer fixId);

    /**
     * 插入一条信息
     * @param ownMaterialFix
     * @return success:1 flase:0
     */
    int insertOwnMaterialFix(OwnMaterialFix ownMaterialFix);

    /**
     * 更改信息
     * @param ownMaterialFix
     * @return success:1 flase:0
     */
    int updateOwnMaterialFix(OwnMaterialFix ownMaterialFix);

    /**
     * 通过id删除拥有信息
     * @param ownId
     * @return
     */
    int deleteOwnMaterialFix(Integer ownId);
}
