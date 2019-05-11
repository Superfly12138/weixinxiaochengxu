package com.superfly.cms.dao;

import com.superfly.cms.entity.Material;

import java.util.List;

public interface MaterialDao {
    /**
     * 查询所有的材料
     * @return
     */
    List<Material> queryMaterial();

    /**
     * 通过Id查询材料
     * @param MaterialId
     * @return 单个材料
     */
    Material queryMaterialById(Integer MaterialId);

    /**
     * 插入材料信息
     * @param Material
     * @return success:1 flase:0
     */
    int insertMaterial(Material Material);

    /**
     * 更新材料信息
     * @param Material
     * @return success:1 flase:0
     */
    int updateMaterial(Material Material);

    /**
     * 通过传入的Id删除材料列表
     * @param MaterialId
     * @return success:1 flase:0
     */
    int deleteMaterial(Integer MaterialId);
}
