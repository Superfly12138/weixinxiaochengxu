package com.superfly.cms.dao;

import com.superfly.cms.entity.Manager;

import java.util.List;

public interface ManagerDao {

    /**
     * 查询所有的经理
     *
     * @return 经理列表
     */
    List<Manager> queryManager();

    /**
     * @param managerId 通过Id查询经理
     * @return 单个经理
     */
    Manager queryManagerById(Integer managerId);

    /**
     * @param managerName 通过name查询经理
     * @return 经理列表
     */
    List<Manager> queryManagerByName(String managerName);

    /**
     * @param managerPhone 通过手机号查询经理
     * @return 单个经理
     */
    Manager queryManagerByPhone(String managerPhone);

    /**
     * @param managerEmail 通过邮箱查询经理
     * @return 单个经理
     */
    Manager queryManagerByEmail(String managerEmail);

    /**
     * 插入经理信息
     *
     * @param manager
     * @return success:1 flase:0
     */
    int insertManager(Manager manager);

    /**
     * 更新经理信息,注册时间不建议更新
     *
     * @param manager
     * @return success:1 flase:0
     */
    int updateManager(Manager manager);

    /**
     * 通过传入的Id删除经理列表
     *
     * @param managerId
     * @return success:1 flase:0
     */
    int deleteManager(Integer managerId);
}
