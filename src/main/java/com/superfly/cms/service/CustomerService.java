package com.superfly.cms.service;

import com.superfly.cms.entity.Car;
import com.superfly.cms.entity.Customer;
import com.superfly.cms.entity.Fix;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    /**
     * 查询所有的顾客信息
     * @return
     */
    List<Customer> getCustomerList();
    /**
     * 查询所有的顾客信息(通过名称筛选)
     * @return
     */
    List<Customer> getCustomerListFilterName(String cusName);
    /**
     * 根据客户Id获取客户信息
     *
     * @param cusId
     * @return Customer
     */
    Customer getCustomerById(Integer cusId);

    /**
     * 注册
     *
     * @param customer
     * @return success:true else:false
     */
    boolean addCustomer(Customer customer);

    /**
     * 通过姓名登录
     *
     * @param cusName
     * @param cusPassword
     * @return success:true else:false
     */
    boolean loginCustomerByName(String cusName, String cusPassword);

    /**
     * 通过手机登录
     *
     * @param cusPhone
     * @param cusPassword
     * @return success:true else:false
     */
    boolean loginCustomerByPhone(String cusPhone, String cusPassword);

    /**
     * 通过邮箱登录
     *
     * @param cusEmail
     * @param cusPassword
     * @return success:true else:false
     */
    boolean loginCustomerByEmail(String cusEmail, String cusPassword);

    /**
     * 修改客户信息
     *
     * @param customer
     * @return success:true else:false
     */
    boolean modifyCustomer(Customer customer);

    /**
     * 注销客户信息
     *
     * @param cusId
     * @return success:true else:false
     */
    boolean deleteCustomer(Integer cusId);

    /**
     * 通过客户Id查询客户的所有汽车
     * @param cusId
     * @return List<Car>
     */
    List<Car> queryCarList(Integer cusId);

    /**
     * 通过汽车Id查询汽车
     * @param carId
     * @return
     */
    Car queryCarByCarId(Integer carId);

    /**
     * 通过汽车车牌查询汽车
     * @param carNumber
     * @return
     */
    Car queryCarByCarNumber(String carNumber);

    /**
     * 添加汽车信息
     *
     * @param car
     * @param cusId
     * @return success:true else:false
     */
    boolean addCar(Car car, Integer cusId);

    /**
     * 修改车辆信息
     *
     * @param car 传入的汽车信息包括汽车编号
     * @return success:true else:false
     */
    boolean modifyCar(Car car);

    /**
     * 删除汽车信息
     *
     * @param carId
     * @return success:true else:false
     */
    boolean deleteCar(Integer carId);
    /**
     * 新建维修单信息
     * @param fix
     * @return true or false
     */
    boolean addFix(Fix fix);

    /**
     * 新建维修单信息
     * @param map
     * @return true or false
     */
    boolean addNewFix(Map map);

}
