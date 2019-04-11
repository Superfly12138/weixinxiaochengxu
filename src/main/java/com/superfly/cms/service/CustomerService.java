package com.superfly.cms.service;

import com.superfly.cms.entity.Car;
import com.superfly.cms.entity.Customer;

public interface CustomerService {
    /**
     * 根据顾客Id获取顾客信息
     * @param cusId
     * @return Customer
     */
    Customer getCustomerById(Integer cusId);
    /**
     * 注册
     * @param customer
     * @return success:true else:false
     */
    boolean addCustomer(Customer customer);

    /**
     * 通过姓名登录
     * @param cusName
     * @param cusPassword
     * @return success:true else:false
     */
    boolean loginCustomerByName(String cusName,String cusPassword);
    /**
     * 通过手机登录
     * @param cusPhone
     * @param cusPassword
     * @return success:true else:false
     */
    boolean loginCustomerByPhone(String cusPhone,String cusPassword);
    /**
     * 通过邮箱登录
     * @param cusEmail
     * @param cusPassword
     * @return success:true else:false
     */
    boolean loginCustomerByEmail(String cusEmail,String cusPassword);

    /**
     * 修改客户信息
     * @param customer
     * @return success:true else:false
     */
    boolean modifyCustomer(Customer customer);

    /**
     * 注销客户信息
     * @param cusId
     * @return success:true else:false
     */
    boolean deleteCustomer(Integer cusId);



    /**
     * 添加汽车信息
     * @param car
     * @param cusId
     * @return success:true else:false
     */
    boolean addCar(Car car,Integer cusId);

    /**
     * 修改车辆信息
     * @param car 传入的汽车信息包括汽车编号
     * @return success:true else:false
     */
    boolean modifyCar(Car car);

    /**
     * 删除汽车信息
     * @param carId
     * @return success:true else:false
     */
    boolean deleteCar(Integer carId);

}
