package com.superfly.cms.service;

import com.superfly.cms.entity.*;

import java.util.List;

public interface ManagerService {
    /**
     * 根据经理Id获取经理信息
     *
     * @param managerId
     * @return Manager
     */
    Manager getManagerById(Integer managerId);

    /**
     * 注册
     *
     * @param manager
     * @return success:true else:false
     */
    boolean addManager(Manager manager);

    /**
     * 通过姓名登录
     *
     * @param managerName
     * @param managerPassword
     * @return success:true else:false
     */
    boolean loginManagerByName(String managerName, String managerPassword);

    /**
     * 通过手机登录
     *
     * @param managerPhone
     * @param managerPassword
     * @return success:true else:false
     */
    boolean loginManagerByPhone(String managerPhone, String managerPassword);

    /**
     * 通过邮箱登录
     *
     * @param managerEmail
     * @param managerPassword
     * @return success:true else:false
     */
    boolean loginManagerByEmail(String managerEmail, String managerPassword);

    /**
     * 修改经理信息
     *
     * @param manager
     * @return success:true else:false
     */
    boolean modifyManager(Manager manager);

    /**
     * 注销经理信息
     *
     * @param managerId
     * @return success:true else:false
     */
    boolean deleteManager(Integer managerId);

    /**
     * 查询所有的故障定义信息
     *
     * @return List<FaultDefinition>
     */
    List<FaultDefinition> queryFaultDefinitionList();

    /**
     * 根据故障Id查询故障信息
     * @param faultId
     * @return FaultDefinition
     */
    FaultDefinition queryFaultDefinition(Integer faultId);

    /**
     * 添加故障信息
     * @param faultDefinition
     * @return true or false
     */
    boolean addFaultDefinition(FaultDefinition faultDefinition);

    /**
     * 更改故障的信息
     * @param faultDefinition
     * @return true or false
     */
    boolean modifyFaultDefinition(FaultDefinition faultDefinition);

    /**
     * 根据故障Id删除故障信息
     * @param faultId
     * @return true or false
     */
    boolean deleteFaultDefinition(Integer faultId);

    /**
     * 查询所有的其它费用信息
     *
     * @return List<OtherCost>
     */
    List<OtherCost> queryOtherCostList();

    /**
     * 根据其它费用Id查询其它费用信息
     * @param otherCostId
     * @return OtherCost
     */
    OtherCost queryOtherCost(Integer otherCostId);

    /**
     * 添加其它费用信息
     * @param otherCost
     * @return true or false
     */
    boolean addOtherCost(OtherCost otherCost);

    /**
     * 更改其它费用的信息
     * @param otherCost
     * @return true or false
     */
    boolean modifyOtherCost(OtherCost otherCost);

    /**
     * 根据其它费用Id删除其它费用信息
     * @param otherCostId
     * @return true or false
     */
    boolean deleteOtherCost(Integer otherCostId);

    /**
     * 查询所有的维修规定信息
     *
     * @return List<RepairRegulations>
     */
    List<RepairRegulations> queryRepairRegulationsList();

    /**
     * 根据维修规定Id查询维修规定信息
     * @param repairRegulationsId
     * @return RepairRegulations
     */
    RepairRegulations queryRepairRegulations(Integer repairRegulationsId);

    /**
     * 添加维修规定信息
     * @param repairRegulations
     * @return true or false
     */
    boolean addRepairRegulations(RepairRegulations repairRegulations);

    /**
     * 更改维修规定的信息
     * @param repairRegulations
     * @return true or false
     */
    boolean modifyRepairRegulations(RepairRegulations repairRegulations);

    /**
     * 根据维修规定Id删除维修规定信息
     * @param repairRegulationsId
     * @return true or false
     */
    boolean deleteRepairRegulations(Integer repairRegulationsId);





    /**
     * 查询所有的维修班组信息
     *
     * @return List<RepairTeam>
     */
    List<RepairTeam> queryRepairTeamList();

    /**
     * 根据维修班组Id查询维修班组信息
     * @param repairTeamId
     * @return RepairTeam
     */
    RepairTeam queryRepairTeam(Integer repairTeamId);

    /**
     * 添加维修班组信息
     * @param repairTeam
     * @return true or false
     */
    boolean addRepairTeam(RepairTeam repairTeam);

    /**
     * 更改维修班组的信息
     * @param repairTeam
     * @return true or false
     */
    boolean modifyRepairTeam(RepairTeam repairTeam);

    /**
     * 根据维修班组Id删除维修班组信息
     * @param repairTeamId
     * @return true or false
     */
    boolean deleteRepairTeam(Integer repairTeamId);



}
