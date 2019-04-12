package com.superfly.cms.dao;

import com.superfly.cms.entity.Repairman;

import java.util.List;

public interface RepairmanDao {
    /**
     * 查询所有的维修人员
     * @return 维修人员列表
     */
    List<Repairman> queryRepairman();

    /**
     * 根据维修班组id查询维修人员
     * @param repairTeamId
     * @return 维修人员列表
     */
    List<Repairman> queryRepairmanByRepairTeamId(Integer repairTeamId);

    /**
     * 根据保养班组id查询维修人员
     * @param maintainTeamId
     * @return 维修人员列表
     */
    List<Repairman> queryRepairmanByMaintainTeamId(Integer maintainTeamId);

    /**
     * 通过维修Id查询维修人员
     * @param repairmanId  维修Id
     * @return 单个维修人员
     */
    Repairman queryRepairmanById(Integer repairmanId);
    /**
     * @param repairmanName 通过name查询维修人员
     * @return 维修人员列表
     */
    List<Repairman> queryRepairmanByName(String repairmanName);

    /**
     * @param repairmanPhone 通过手机号查询维修人员
     * @return 单个维修人员
     */
    Repairman queryRepairmanByPhone(String repairmanPhone);

    /**
     * @param repairmanEmail 通过邮箱查询维修人员
     * @return 单个维修人员
     */
    Repairman queryRepairmanByEmail(String repairmanEmail);


    /**
     * 插入维修人员信息
     * @param repairman
     * @return success:1 flase:0
     */
    int insertRepairman(Repairman repairman);

    /**
     * 更新维修人员信息注册时间不建议更新
     * @param repairman
     * @return success:1 flase:0
     */
    int updateRepairman(Repairman repairman);

    /**
     * 通过传入的Id删除维修人员列表
     * @param repairmanId
     * @return success:1 flase:0
     */
    int deleteRepairman(Integer repairmanId);
}
