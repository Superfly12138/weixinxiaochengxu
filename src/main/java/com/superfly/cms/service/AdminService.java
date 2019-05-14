package com.superfly.cms.service;

import com.superfly.cms.entity.*;

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



    /**
     * 查询当天销售统计
     *
     * @return List<Instock>
     */
    List<OwnMaterialFix> queryOwnMaterialFixSellToday();

    /**
     * 查询所有入库单
     *
     * @return List<Instock>
     */
    List<Instock> queryInstockList();

    /**
     * 查询当天统计入库单
     *
     * @return List<Instock>
     */
    List<Instock> queryInstockListToday();

    /**
     * 通过入库单Id查询入库单
     * @param instockId
     * @return
     */
    Instock queryInstockByInstockId(Integer instockId);

    /**
     * 添加入库单信息
     *
     * @param instock
     *
     * @return success:true else:false
     */
    boolean addInstock(Instock instock);

    /**
     * 修改入库单信息
     *
     * @param instock 传入的入库单信息包括入库单编号
     * @return success:true else:false
     */
    boolean modifyInstock(Instock instock);

    /**
     * 删除入库单信息
     *
     * @param instockId
     * @return success:true else:false
     */
    boolean deleteInstock(Integer instockId);




    /**
     * 查询所有出库单
     *
     * @return List<Outstock>
     */
    List<Outstock> queryOutstockList();

    /**
     * 查询当天统计出库单
     *
     * @return List<Instock>
     */
    List<Outstock> queryOutstockListToday();

    /**
     * 通过出库单Id查询出库单
     * @param outstockId
     * @return
     */
    Outstock queryOutstockByOutstockId(Integer outstockId);

    /**
     * 添加出库单信息
     *
     * @param outstock
     *
     * @return success:true else:false
     */
    boolean addOutstock(Outstock outstock);

    /**
     * 修改出库单信息
     *
     * @param outstock 传入的出库单信息包括出库单编号
     * @return success:true else:false
     */
    boolean modifyOutstock(Outstock outstock);

    /**
     * 删除出库单信息
     *
     * @param outstockId
     * @return success:true else:false
     */
    boolean deleteOutstock(Integer outstockId);


    /**
     * 查询所有维修项目表
     *
     * @return List<OwnRegulationsFix>
     */
    List<OwnRegulationsFix> queryOwnRegulationsFixList();

    /**
     * 通过fixId查询所有维修项目表
     *
     * @return List<OwnRegulationsFix>
     */
    List<OwnRegulationsFix> queryOwnRegulationsFixListByFixId(Integer fixId);

    /**
     * 查询所有维修项目表
     *
     * @return List<OwnMaterialFix>
     */
    List<OwnMaterialFix> queryOwnMaterialFixList();

    /**
     * 通过fixId查询所有维修项目表
     *
     * @return List<OwnMaterialFix>
     */
    List<OwnMaterialFix> queryOwnMaterialFixListByFixId(Integer fixId);



}
