package com.superfly.cms.service;

import com.superfly.cms.entity.Fix;
import com.superfly.cms.entity.Repairman;

import java.util.List;

public interface RepairmanService {
    /**
     * 根据维修人员Id获取维修人员信息
     *
     * @param repairmanId
     * @return Repairman
     */
    Repairman getRepairmanById(Integer repairmanId);

    /**
     * 注册
     *
     * @param repairman
     * @return success:true else:false
     */
    boolean addRepairman(Repairman repairman);

    /**
     * 通过姓名登录
     *
     * @param repairmanName
     * @param repairmanPassword
     * @return success:true else:false
     */
    boolean loginRepairmanByName(String repairmanName, String repairmanPassword);

    /**
     * 通过手机登录
     *
     * @param repairmanPhone
     * @param repairmanPassword
     * @return success:true else:false
     */
    boolean loginRepairmanByPhone(String repairmanPhone, String repairmanPassword);

    /**
     * 通过邮箱登录
     *
     * @param repairmanEmail
     * @param repairmanPassword
     * @return success:true else:false
     */
    boolean loginRepairmanByEmail(String repairmanEmail, String repairmanPassword);

    /**
     * 修改维修人员信息
     *
     * @param repairman
     * @return success:true else:false
     */
    boolean modifyRepairman(Repairman repairman);

    /**
     * 注销维修人员信息
     *
     * @param repairmanId
     * @return success:true else:false
     */
    boolean deleteRepairman(Integer repairmanId);

    //维修部分

    /**
     * 查询所有的维修信息
     * @return
     */
    List<Fix> queryFixList();

    /**
     * 根据维修Id查询维修信息
     * @param fixId
     * @return
     */
    Fix queryFixByFixId(Integer fixId);

    /**
     * 通过维修人员所在维修组编号查询维修信息
     * @param repairTeamId
     * @return
     */
    List<Fix> queryFixByRepairTeamId(Integer repairTeamId);
    /**
     * 通过保养人员所在保养组编号查询维修信息
     * @param maintainTeamId
     * @return
     */
    List<Fix> queryFixByMaintainTeamId(Integer maintainTeamId);

    /**
     * 接收维修单（要求存在于维修班组）
     * @param fix
     * @return
     */
    boolean acceptFix(Fix fix);

    /**
     * 完成维修单
     * @param fix
     * @return
     */
    boolean finishFix(Fix fix);
}
