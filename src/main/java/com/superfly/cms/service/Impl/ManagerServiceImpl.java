package com.superfly.cms.service.Impl;

import com.superfly.cms.dao.*;
import com.superfly.cms.entity.*;
import com.superfly.cms.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private FaultDefinitionDao faultDefinitionDao;
    @Autowired
    private OtherCostDao otherCostDao;
    @Autowired
    private RepairRegulationsDao repairRegulationsDao;
    @Autowired
    private RepairTeamDao repairTeamDao;

    /**
     * 根据经理Id获取经理信息
     *
     * @param managerId
     * @return Manager
     */
    @Override
    public Manager getManagerById(Integer managerId) {
        try {
            return managerDao.queryManagerById(managerId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 注册
     *
     * @param manager
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean addManager(Manager manager) {
        if (manager == null) {
            throw new RuntimeException("前端传入数据无效，添加客户失败！");
        }
        //判断插入的数据是否为空
        if (manager.getManagerName() != null && !"".equals(manager.getManagerName())) {
            if (manager.getManagerPassword() != null && !"".equals(manager.getManagerPassword())) {
                if (manager.getManagerSex() != null && !"".equals(manager.getManagerSex())) {
                    if (manager.getManagerAge() != null) {
                        if (manager.getManagerPhone() != null && !"".equals(manager.getManagerPhone())) {
                            if (manager.getManagerAddress() != null && !"".equals(manager.getManagerAddress())) {
                                if (manager.getManagerEmail() != null && !"".equals(manager.getManagerEmail())) {
                                    //设置注册时间
                                    manager.setManagerRegistrationDate(new Date());
                                    try {
                                        int effectedNumber = managerDao.insertManager(manager);
                                        if (effectedNumber > 0) {
                                            return true;
                                        } else {
                                            throw new RuntimeException("用户注册失败！");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException("用户注册失败！" + e.toString());
                                    }

                                } else {
                                    throw new RuntimeException("邮箱不能为空！");
                                }
                            } else {
                                throw new RuntimeException("地址不能为空！");
                            }
                        } else {
                            throw new RuntimeException("手机号不能为空！");
                        }
                    } else {
                        throw new RuntimeException("年龄不能为空！");
                    }
                } else {
                    throw new RuntimeException("性别不能为空！");
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    /**
     * 通过姓名登录
     *
     * @param managerName
     * @param managerPassword
     * @return success:true else:false
     */
    @Override
    public boolean loginManagerByName(String managerName, String managerPassword) {
        if (managerName != null && !"".equals(managerName)) {
            if (managerPassword != null && !"".equals(managerPassword)) {
                try {
                    //通过姓名登录获取password（只有一个用户名时才有效）
                    List<Manager> list = managerDao.queryManagerByName(managerName);
                    if (list.size() < 1) {
                        throw new RuntimeException("姓名不存在！");
                    } else if (list.size() == 1) {
                        if (list.get(0).getManagerPassword().equals(managerPassword)) {
                            return true;
                        } else {
                            throw new RuntimeException("密码错误！");
                        }
                    } else {
                        throw new RuntimeException("姓名存在重复，请使用其他方式登录！");
                    }

                } catch (Exception e) {
                    throw new RuntimeException("登录失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    /**
     * 通过手机登录
     *
     * @param managerPhone
     * @param managerPassword
     * @return success:true else:false
     */
    @Override
    public boolean loginManagerByPhone(String managerPhone, String managerPassword) {
        if (managerPhone != null && !"".equals(managerPhone)) {
            if (managerPassword != null && !"".equals(managerPassword)) {
                try {
                    //通过手机号登录获取password
                    if (managerDao.queryManagerByPhone(managerPhone) == null) {
                        throw new RuntimeException("手机号不存在！");
                    } else if (managerDao.queryManagerByPhone(managerPhone).getManagerPassword().equals(managerPassword)) {
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
            throw new RuntimeException("手机号不能为空！");
        }
    }

    /**
     * 通过邮箱登录
     *
     * @param managerEmail
     * @param managerPassword
     * @return success:true else:false
     */
    @Override
    public boolean loginManagerByEmail(String managerEmail, String managerPassword) {
        if (managerEmail != null && !"".equals(managerEmail)) {
            if (managerPassword != null && !"".equals(managerPassword)) {
                try {
                    //通过邮箱登录获取password
                    if (managerDao.queryManagerByEmail(managerEmail) == null) {
                        throw new RuntimeException("邮箱不存在！");
                    } else if (managerDao.queryManagerByEmail(managerEmail).getManagerPassword().equals(managerPassword)) {
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
            throw new RuntimeException("邮箱不能为空！");
        }
    }

    /**
     * 修改经理信息
     *
     * @param manager
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean modifyManager(Manager manager) {
        if (manager == null) {
            throw new RuntimeException("前端传入数据无效，添加客户失败！");
        }
        if (manager.getManagerName() != null && !"".equals(manager.getManagerName())) {
            if (manager.getManagerPassword() != null && !"".equals(manager.getManagerPassword())) {
                if (manager.getManagerSex() != null && !"".equals(manager.getManagerSex())) {
                    if (manager.getManagerAge() != null) {
                        if (manager.getManagerPhone() != null && !"".equals(manager.getManagerPhone())) {
                            if (manager.getManagerAddress() != null && !"".equals(manager.getManagerAddress())) {
                                if (manager.getManagerEmail() != null && !"".equals(manager.getManagerEmail())) {

                                    try {
                                        int effectedNumber = managerDao.updateManager(manager);
                                        if (effectedNumber > 0) {
                                            return true;
                                        } else {
                                            throw new RuntimeException("更新失败！");
                                        }
                                    } catch (Exception e) {
                                        throw new RuntimeException("更新失败！" + e.toString());
                                    }

                                } else {
                                    throw new RuntimeException("邮箱不能为空！");
                                }
                            } else {
                                throw new RuntimeException("地址不能为空！");
                            }
                        } else {
                            throw new RuntimeException("手机号不能为空！");
                        }
                    } else {
                        throw new RuntimeException("年龄不能为空！");
                    }
                } else {
                    throw new RuntimeException("性别不能为空！");
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("姓名不能为空！");
        }
    }

    /**
     * 注销经理信息
     *
     * @param managerId
     * @return success:true else:false
     */
    @Transactional
    @Override
    public boolean deleteManager(Integer managerId) {
        try {
            //删除用户
            int effectedNum = managerDao.deleteManager(managerId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("注销用户失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("注销用户失败:" + e.toString());
        }
    }

    /**
     * 查询所有的故障定义信息
     *
     * @return List<FaultDefinition>
     */
    @Override
    public List<FaultDefinition> queryFaultDefinitionList() {
        try {
            return faultDefinitionDao.queryFaultDefinition();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据故障Id查询故障信息
     *
     * @param faultId
     * @return FaultDefinition
     */
    @Override
    public FaultDefinition queryFaultDefinition(Integer faultId) {
        try {
            return faultDefinitionDao.queryFaultDefinitionById(faultId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加故障信息
     *
     * @param faultDefinition
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addFaultDefinition(FaultDefinition faultDefinition) {
        if (faultDefinition == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (faultDefinition.getFaultName() != null && !"".equals(faultDefinition.getFaultName())) {
            if (faultDefinition.getFaultType() != null && !"".equals(faultDefinition.getFaultType())) {
                try {
                    int effectedNumber = faultDefinitionDao.insertFaultDefinition(faultDefinition);
                    if (effectedNumber > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("添加故障信息失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("添加故障信息失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("类型不能为空！");
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 更改故障的信息
     *
     * @param faultDefinition
     * @return true or false
     */
    @Transactional
    @Override
    public boolean modifyFaultDefinition(FaultDefinition faultDefinition) {
        if (faultDefinition == null) {
            throw new RuntimeException("前端传入数据无效，更新信息失败！");
        }
        if (faultDefinition.getFaultName() != null && !"".equals(faultDefinition.getFaultName())) {
            if (faultDefinition.getFaultType() != null && !"".equals(faultDefinition.getFaultType())) {
                try {
                    int effectedNumber = faultDefinitionDao.updateFaultDefinition(faultDefinition);
                    if (effectedNumber > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("更新故障信息失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("更新故障信息失败！" + e.toString());
                }
            } else {
                throw new RuntimeException("类型不能为空！");
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 根据故障Id删除故障信息
     *
     * @param faultId
     * @return true or false
     */
    @Transactional
    @Override
    public boolean deleteFaultDefinition(Integer faultId) {
        try {
            int effectedNum = faultDefinitionDao.deleteFaultDefinition(faultId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除故障信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除故障信息失败:" + e.toString());
        }
    }

    /**
     * 查询所有的其它费用信息
     *
     * @return List<OtherCost>
     */
    @Override
    public List<OtherCost> queryOtherCostList() {
        try {
            return otherCostDao.queryOtherCost();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据其它费用Id查询其它费用信息
     *
     * @param otherCostId
     * @return OtherCost
     */
    @Override
    public OtherCost queryOtherCost(Integer otherCostId) {
        try {
            return otherCostDao.queryOtherCostById(otherCostId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加其它费用信息
     *
     * @param otherCost
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addOtherCost(OtherCost otherCost) {
        if (otherCost == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (otherCost.getOtherCostName() != null && !"".equals(otherCost.getOtherCostName())) {
            try {
                int effectedNumber = otherCostDao.insertOtherCost(otherCost);
                if (effectedNumber > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加其它费用信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加其它费用信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 更改其它费用的信息
     *
     * @param otherCost
     * @return true or false
     */
    @Transactional
    @Override
    public boolean modifyOtherCost(OtherCost otherCost) {
        if (otherCost == null) {
            throw new RuntimeException("前端传入数据无效，更新其它费用信息失败！");
        }
        if (otherCost.getOtherCostName() != null && !"".equals(otherCost.getOtherCostName())) {
            try {
                int effectedNumber = otherCostDao.updateOtherCost(otherCost);
                if (effectedNumber > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新其它费用信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新其它费用信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 根据其它费用Id删除其它费用信息
     *
     * @param otherCostId
     * @return true or false
     */
    @Transactional
    @Override
    public boolean deleteOtherCost(Integer otherCostId) {
        try {
            int effectedNum = otherCostDao.deleteOtherCost(otherCostId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除其它费用信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除其它费用信息失败:" + e.toString());
        }
    }

    /**
     * 查询所有的维修规定信息
     *
     * @return List<RepairRegulations>
     */
    @Override
    public List<RepairRegulations> queryRepairRegulationsList() {
        try {
            return repairRegulationsDao.queryRepairRegulations();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据维修规定Id查询维修规定信息
     *
     * @param repairRegulationsId
     * @return RepairRegulations
     */
    @Override
    public RepairRegulations queryRepairRegulations(Integer repairRegulationsId) {
        try {
            return repairRegulationsDao.queryRepairRegulationsById(repairRegulationsId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加维修规定信息
     *
     * @param repairRegulations
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addRepairRegulations(RepairRegulations repairRegulations) {
        if (repairRegulations == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (repairRegulations.getRepairName() != null && !"".equals(repairRegulations.getRepairName())) {
            if (repairRegulations.getRepairType() != null && !"".equals(repairRegulations.getRepairType())) {
                if (repairRegulations.getRepairMoney() != null && !"".equals(repairRegulations.getRepairMoney())) {
                    try {
                        int effectedNumber = repairRegulationsDao.insertRepairRegulations(repairRegulations);
                        if (effectedNumber > 0) {
                            return true;
                        } else {
                            throw new RuntimeException("添加维修规定信息失败！");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("添加维修规定信息失败！" + e.toString());
                    }
                } else {
                    throw new RuntimeException("金额不能为空！");
                }

            } else {
                throw new RuntimeException("类型不能为空！");
            }

        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 更改维修规定的信息
     *
     * @param repairRegulations
     * @return true or false
     */
    @Transactional
    @Override
    public boolean modifyRepairRegulations(RepairRegulations repairRegulations) {
        if (repairRegulations == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (repairRegulations.getRepairName() != null && !"".equals(repairRegulations.getRepairName())) {
            if (repairRegulations.getRepairType() != null && !"".equals(repairRegulations.getRepairType())) {
                if (repairRegulations.getRepairMoney() != null && !"".equals(repairRegulations.getRepairMoney())) {
                    try {
                        int effectedNumber = repairRegulationsDao.updateRepairRegulations(repairRegulations);
                        if (effectedNumber > 0) {
                            return true;
                        } else {
                            throw new RuntimeException("更改维修规定信息失败！");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("更改维修规定信息失败！" + e.toString());
                    }
                } else {
                    throw new RuntimeException("金额不能为空！");
                }

            } else {
                throw new RuntimeException("类型不能为空！");
            }

        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 根据维修规定Id删除维修规定信息
     *
     * @param repairRegulationsId
     * @return true or false
     */
    @Transactional
    @Override
    public boolean deleteRepairRegulations(Integer repairRegulationsId) {
        try {
            int effectedNum = repairRegulationsDao.deleteRepairRegulations(repairRegulationsId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除维修规定信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除维修规定信息失败:" + e.toString());
        }
    }

    /**
     * 查询所有的维修班组信息
     *
     * @return List<RepairRegulations>
     */
    @Override
    public List<RepairTeam> queryRepairTeamList() {
        try {
            return repairTeamDao.queryRepairTeam();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 根据维修班组Id查询维修班组信息
     *
     * @param repairTeamId
     * @return RepairTeam
     */
    @Override
    public RepairTeam queryRepairTeam(Integer repairTeamId) {
        try {
            return repairTeamDao.queryRepairTeamById(repairTeamId);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /**
     * 添加维修班组信息
     *
     * @param repairTeam
     * @return true or false
     */
    @Transactional
    @Override
    public boolean addRepairTeam(RepairTeam repairTeam) {
        if (repairTeam == null) {
            throw new RuntimeException("前端传入数据无效，添加信息失败！");
        }
        if (repairTeam.getRepairTeamName() != null && !"".equals(repairTeam.getRepairTeamName())) {
            try {
                int effectedNumber = repairTeamDao.insertRepairTeam(repairTeam);
                if (effectedNumber > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加维修班组信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加维修班组信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 更新维修班组的信息
     *
     * @param repairTeam
     * @return true or false
     */
    @Transactional
    @Override
    public boolean modifyRepairTeam(RepairTeam repairTeam) {
        if (repairTeam == null) {
            throw new RuntimeException("前端传入数据无效，更新维修班组信息失败！");
        }
        if (repairTeam.getRepairTeamName() != null && !"".equals(repairTeam.getRepairTeamName())) {
            try {
                int effectedNumber = repairTeamDao.updateRepairTeam(repairTeam);
                if (effectedNumber > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新维修班组信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新维修班组信息失败！" + e.toString());
            }
        } else {
            throw new RuntimeException("名称不能为空！");
        }
    }

    /**
     * 根据维修班组Id删除维修班组信息
     *
     * @param repairTeamId
     * @return true or false
     */
    @Transactional
    @Override
    public boolean deleteRepairTeam(Integer repairTeamId) {
        try {
            int effectedNum = repairTeamDao.deleteRepairTeam(repairTeamId);
            if (effectedNum > 0) {
                return true;
            } else {
                throw new RuntimeException("删除维修班组信息失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除维修班组信息失败:" + e.toString());
        }
    }
}
