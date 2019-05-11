package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.AdminDao;
import com.superfly.cms.dao.RepairTypeDao;
import com.superfly.cms.entity.RepairType;
import com.superfly.cms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private RepairTypeDao repairTypeDao;

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


}
