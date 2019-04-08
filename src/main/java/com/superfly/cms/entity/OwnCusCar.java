package com.superfly.cms.entity;

/**
 * 对应own_cus_car_t拥有表
 */
public class OwnCusCar {
    private Integer ownId;
    private Integer cusId;
    private Integer carId;

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
