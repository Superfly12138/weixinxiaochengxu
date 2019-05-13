package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.*;
import com.superfly.cms.entity.*;
import com.superfly.cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private RepairTypeDao repairTypeDao;
    @Autowired
    private MaterialDao materialDao;
    @Autowired
    private InstockDao instockDao;
    @Autowired
    private OutstockDao outstockDao;
    @Autowired
    private OwnRegulationsFixDao ownRegulationsFixDao;
    @Autowired
    private OwnMaterialFixDao ownMaterialFixDao;

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

    /**
     * 查询所有入库单
     *
     * @return List<Instock>
     */
    @Override
    public List<Instock> queryInstockList() {
        try {
            return instockDao.queryInstock();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 查询当天统计入库单
     *
     * @return List<Instock>
     */
    @Override
    public List<Instock> queryInstockListToday() {
        try {
            Date date1 = new Date();
            Date date2 = new Date();
            Calendar cal = new GregorianCalendar();
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            date2 =cal.getTime();

            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            date1 =cal.getTime();

            return instockDao.queryInstockToday(date1,date2);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过入库单Id查询入库单
     *
     * @param instockId
     * @return
     */
    @Override
    public Instock queryInstockByInstockId(Integer instockId) {
        try {
            return instockDao.queryInstockById(instockId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加入库单信息
     *
     * @param instock
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean addInstock(Instock instock) {
        if (instock == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (instock.getMaterialId() != null && !"".equals(instock.getMaterialId())) {
            if (instock.getInstockNumber() != null && !"".equals(instock.getInstockNumber())) {
                        try {
                            instock.setInstockTime(new Date());
                            int effectedNumber = instockDao.insertInstock(instock);
                            if (effectedNumber > 0) {
                              Material material = materialDao.queryMaterialById(instock.getMaterialId());
                                material.setMaterialNumber(material.getMaterialNumber() + instock.getInstockNumber());
                                if(materialDao.updateMaterial(material) > 0){
                                    return true;
                                }else{
                                    throw new RuntimeException("新建入库单失败！");
                                }
                            } else {
                                throw new RuntimeException("新建入库单失败！");
                            }
                        } catch (Exception e) {
                            throw new RuntimeException("新建入库单失败！" + e.toString());
                        }
            } else {
                throw new RuntimeException("数量不能为空！");
            }
        } else {
            throw new RuntimeException("材料Id不能为空！");
        }
    }

    /**
     * 修改入库单信息
     *
     * @param instock 传入的入库单信息包括入库单编号
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean modifyInstock(Instock instock) {
        if (instock == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (instock.getMaterialId() != null && !"".equals(instock.getMaterialId())) {
            if (instock.getInstockNumber() != null && !"".equals(instock.getInstockNumber())) {
                try {
                    instock.setInstockTime(new Date());
                    int effectedNumber = instockDao.updateInstock(instock);
                    if (effectedNumber > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("修改入库单失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("修改入库单失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("数量不能为空！");
            }
        } else {
            throw new RuntimeException("材料Id不能为空！");
        }
    }

    /**
     * 删除入库单信息
     *
     * @param instockId
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean deleteInstock(Integer instockId) {
        try {
            int effectedNum = instockDao.deleteInstock(instockId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败:" + e.toString());
        }
    }

    /**
     * 查询所有出库单
     *
     * @return List<Outstock>
     */
    @Override
    public List<Outstock> queryOutstockList() {
        try {
            return outstockDao.queryOutstock();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 查询当天统计出库单
     *
     * @return List<Outstock>
     */
    @Override
    public List<Outstock> queryOutstockListToday() {
        try {
            Date date1 = new Date();
            Date date2 = new Date();
            Calendar cal = new GregorianCalendar();
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            date2 =cal.getTime();

            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            date1 =cal.getTime();


            return outstockDao.queryOutstockToday(date1,date2);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过出库单Id查询出库单
     *
     * @param outstockId
     * @return
     */
    @Override
    public Outstock queryOutstockByOutstockId(Integer outstockId) {
        try {
            return outstockDao.queryOutstockById(outstockId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加出库单信息
     *
     * @param outstock
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean addOutstock(Outstock outstock) {
        if (outstock == null) {
            throw new RuntimeException("前端传出数据无效，添加信息失败！");
        }
        if (outstock.getMaterialId() != null && !"".equals(outstock.getMaterialId())) {
            if (outstock.getOutstockNumber() != null && !"".equals(outstock.getOutstockNumber())) {
                try {
                    outstock.setOutstockTime(new Date());
                    int effectedNumber = outstockDao.insertOutstock(outstock);
                    if (effectedNumber > 0) {
                        Material material = materialDao.queryMaterialById(outstock.getMaterialId());
                        material.setMaterialNumber(material.getMaterialNumber() - outstock.getOutstockNumber());
                        if(material.getMaterialNumber()< 0){
                            throw new RuntimeException(material.getMaterialName()+"数量不足！");
                        }
                        if(materialDao.updateMaterial(material) > 0){
                            return true;
                        }else{
                            throw new RuntimeException("新建出库单失败！");
                        }
                    } else {
                        throw new RuntimeException("新建出库单失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("新建出库单失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("数量不能为空！");
            }
        } else {
            throw new RuntimeException("材料Id不能为空！");
        }
    }

    /**
     * 修改出库单信息
     *
     * @param outstock 传出的出库单信息包括出库单编号
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean modifyOutstock(Outstock outstock) {
        if (outstock == null) {
            throw new RuntimeException("前端传出数据无效，添加信息失败！");
        }
        if (outstock.getMaterialId() != null && !"".equals(outstock.getMaterialId())) {
            if (outstock.getOutstockNumber() != null && !"".equals(outstock.getOutstockNumber())) {
                try {
                    outstock.setOutstockTime(new Date());
                    int effectedNumber = outstockDao.updateOutstock(outstock);
                    if (effectedNumber > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("修改出库单失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("修改出库单失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("数量不能为空！");
            }
        } else {
            throw new RuntimeException("材料Id不能为空！");
        }
    }

    /**
     * 删除出库单信息
     *
     * @param outstockId
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean deleteOutstock(Integer outstockId) {
        try {
            int effectedNum = outstockDao.deleteOutstock(outstockId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败:" + e.toString());
        }
    }

    /**
     * 查询所有维修项目表
     *
     * @return List<Outstock>
     */
    @Override
    public List<OwnRegulationsFix> queryOwnRegulationsFixList() {
        try {
            return ownRegulationsFixDao.queryOwnRegulationsFix();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过fixId查询所有维修项目表
     *
     * @param fixId
     * @return List<Outstock>
     */
    @Override
    public List<OwnRegulationsFix> queryOwnRegulationsFixListByFixId(Integer fixId) {
        try {
            return ownRegulationsFixDao.queryOwnRegulationsFixByFixId(fixId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 查询所有表
     *
     * @return List<OwnMaterialFix>
     */
    @Override
    public List<OwnMaterialFix> queryOwnMaterialFixList() {
        try {
            return ownMaterialFixDao.queryOwnMaterialFix();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 通过fixId查询所有表
     *
     * @param fixId
     * @return List<OwnMaterialFix>
     */
    @Override
    public List<OwnMaterialFix> queryOwnMaterialFixListByFixId(Integer fixId) {
        try {
            return ownMaterialFixDao.queryOwnMaterialFixByFixId(fixId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }


}
