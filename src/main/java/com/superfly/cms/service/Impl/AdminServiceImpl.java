package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.AdminDao;
import com.superfly.cms.dao.MaterialDao;
import com.superfly.cms.dao.RepairTypeDao;
import com.superfly.cms.entity.Material;
import com.superfly.cms.entity.RepairType;
import com.superfly.cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private RepairTypeDao repairTypeDao;
    @Autowired
    private MaterialDao materialDao;

    /**
     * 通过姓名登录
     *
     * @param adminName
     * @param adminPassword
     * @return
     */
    @Override
    public boolean loginAdminByName(String adminName, String adminPassword) {
        if (adminName != null && !"".equals(adminName)) {
            if (adminPassword != null && !"".equals(adminPassword)) {
                try {
                    if (adminDao.queryAdminByName(adminName) == null) {
                        throw new RuntimeException("姓名不存在！");
                    } else if (adminDao.queryAdminByName(adminName).getAdminPassword().equals(adminPassword)) {
                        return true;
                    } else {
                        throw new RuntimeException("密码错误！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("名字不能为空！");
        }
    }

    /**
     * 获取所有的维修类别列表
     *
     * @return
     */
    @Override
    public List<RepairType> getRepairTypeList() {
        try {
            return repairTypeDao.queryRepairType();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过维修类别Id获取维修类别信息
     *
     * @param repairTypeId
     * @return
     */
    @Override
    public RepairType getRepairTypeById(Integer repairTypeId) {
        try {
            return repairTypeDao.queryRepairTypeById(repairTypeId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }




    /**
     * 查询所有的材料信息
     *
     * @return List<Material>
     */
    @Override
    public List<Material> queryMaterialList() {
        try {
            return materialDao.queryMaterial();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据材料Id查询材料信息
     *
     * @param materialId
     * @return Material
     */
    @Override
    public Material queryMaterialByMaterialId(Integer materialId) {
        try {
            return materialDao.queryMaterialById(materialId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加材料信息
     *
     * @param material
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addMaterial(Material material) {
        if (material == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (material.getMaterialName() != null && !"".equals(material.getMaterialName())) {
            if (material.getMaterialNumber() != null && !"".equals(material.getMaterialNumber())) {
                if (material.getMaterialInmoney() != null && !"".equals(material.getMaterialInmoney())) {
                    if (material.getMaterialOutmoney() != null && !"".equals(material.getMaterialOutmoney())) {
                        try {
                            int effectedNumber = materialDao.insertMaterial(material);
                            if (effectedNumber > 0) {
                                return true;
                            } else {
                                throw new RuntimeException("添加材料信息失败！");
                            }
                        } catch (Exception e) {
                            throw new RuntimeException("添加材料信息失败！" + e.toString());
                        }
                    } else {
                        throw new RuntimeException("金额不能为空！");
                    }
                } else {
                    throw new RuntimeException("金额不能为空！");
                }
            } else {
                throw new RuntimeException("数量不能为空！");
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 更改材料的信息
     *
     * @param material
     * @return true or false
     */
    @Transactional
    @Override
    public boolean modifyMaterial(Material material) {
        if (material == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (material.getMaterialName() != null && !"".equals(material.getMaterialName())) {
            if (material.getMaterialNumber() != null && !"".equals(material.getMaterialNumber())) {
                if (material.getMaterialInmoney() != null && !"".equals(material.getMaterialInmoney())) {
                    if (material.getMaterialOutmoney() != null && !"".equals(material.getMaterialOutmoney())) {
                        try {
                            int effectedNumber = materialDao.updateMaterial(material);
                            if (effectedNumber > 0) {
                                return true;
                            } else {
                                throw new RuntimeException("添加材料信息失败！");
                            }
                        } catch (Exception e) {
                            throw new RuntimeException("添加材料信息失败！" + e.toString());
                        }
                    } else {
                        throw new RuntimeException("金额不能为空！");
                    }
                } else {
                    throw new RuntimeException("金额不能为空！");
                }
            } else {
                throw new RuntimeException("数量不能为空！");
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 根据材料Id删除材料信息
     *
     * @param materialId
     * @return true or false
     */
    @Transactional
    @Override
    public boolean deleteMaterial(Integer materialId) {
        try {
            int effectedNum = materialDao.deleteMaterial(materialId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除材料信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除材料信息失败:" + e.toString());
        }
    }


}
