package com.superfly.cms.service;

import com.superfly.cms.entity.Material;
import com.superfly.cms.entity.RepairType;

import java.util.List;

public interface AdminService {
    /**
     * 通过姓名登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    boolean loginAdminByName(String adminName,String adminPassword);

    /**
     * 获取所有的维修列表
     * @return
     */
    List<RepairType> getRepairTypeList();

    /**
     * 通过维修类别Id获取维修类别信息
     * @param repairTypeId
     * @return
     */
    RepairType getRepairTypeById(Integer repairTypeId);



    /**
     * 查询所有材料
     *
     * @return List<Material>
     */
    List<Material> queryMaterialList();

    /**
     * 通过材料Id查询材料
     * @param materialId
     * @return
     */
    Material queryMaterialByMaterialId(Integer materialId);

    /**
     * 添加材料信息
     *
     * @param material
     *
     * @return success:true else:false
     */
    boolean addMaterial(Material material);

    /**
     * 修改材料信息
     *
     * @param material 传入的材料信息包括材料编号
     * @return success:true else:false
     */
    boolean modifyMaterial(Material material);

    /**
     * 删除材料信息
     *
     * @param materialId
     * @return success:true else:false
     */
    boolean deleteMaterial(Integer materialId);

}
