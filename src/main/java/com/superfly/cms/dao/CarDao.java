package com.superfly.cms.dao;

import com.superfly.cms.entity.Car;

import java.util.List;

public interface CarDao {
    /**
     * 查询所有的车辆
     * @return
     */
     List<Car> queryCar();

    /**
     * 通过Id查询车辆
     * @param carId
     * @return 单个车辆
     */
     Car queryCarById(Integer carId);


    /**
     * 通过车牌查询车辆
     * @param carNumber
     * @return 单个车辆
     */
    Car queryCarByCarNumber(String carNumber);

    /**
     * 插入车辆信息
     * @param car
     * @return success:1 flase:0
     */
    int insertCar(Car car);

    /**
     * 更新车辆信息
     * @param car
     * @return success:1 flase:0
     */
    int updateCar(Car car);

    /**
     * 通过传入的Id删除车辆列表
     * @param carId
     * @return success:1 flase:0
     */
    int deleteCar(Integer carId);
}
