package com.superfly.cms.dao;

import com.superfly.cms.entity.OwnCusCar;

import java.util.List;

public interface OwnCusCarDao {
    /**
     * 查询所有的顾客-车辆拥有信息
     * @return
     */
    List<OwnCusCar> queryOwnCusCar();

    /**
     * 通过顾客id查询顾客拥有信息
     * @param cusId
     * @return
     */
    List<OwnCusCar> queryOwnCusCarByCusId(Integer cusId);

    /**
     * 通过车辆id查询顾客拥有信息
     * @param carId
     * @return
     */
    OwnCusCar queryOwnCusCarByCarId(Integer carId);

    /**
     * 插入一条拥有信息
     * @param ownCusCar
     * @return success:1 flase:0
     */
    int insertOwnCusCar(OwnCusCar ownCusCar);

    /**
     * 更改拥有信息
     * @param ownCusCar
     * @return success:1 flase:0
     */
    int updateOwnCusCar(OwnCusCar ownCusCar);

    /**
     * 通过id删除拥有信息
     * @param ownId
     * @return
     */
    int deleteOwnCusCar(Integer ownId);
}
