package com.superfly.cms.dao;

import com.superfly.cms.entity.Customer;

import java.util.List;

public interface CustomerDao {
    /**
     * 查询所有的顾客
     * @return 顾客列表
     */
    List<Customer> queryCustomer();

    /**
     * @param cusId
     * 通过Id查询顾客
     * @return 单个顾客
     */
    Customer queryCustomerById(int cusId);
    /**
     * @param cusName
     * 通过name查询顾客
     * @return 顾客列表
     */
    List<Customer> queryCustomerByName(String cusName);
    /**
     * @param cusPhone
     * 通过手机号查询顾客
     * @return 单个顾客
     */
    Customer queryCustomerByPhone(String cusPhone);
    /**
     * @param cusEmail
     * 通过邮箱查询顾客
     * @return 单个顾客
     */
    Customer queryCustomerByEmail(String cusEmail);

    /**
     * 插入顾客信息
     * @param customer
     * @return success:1 flase:0
     */
    int insertCustomer(Customer customer);

    /**
     * 更新顾客信息,注册时间不建议更新
     * @param customer
     * @return success:1 flase:0
     */
    int updateCustomer(Customer customer);

    /**
     * 通过传入的Id删除顾客列表
     * @param cusId
     * @return success:1 flase:0
     */
    int deleteCustomer(int cusId);
}
