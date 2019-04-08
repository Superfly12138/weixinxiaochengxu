package com.superfly.cms.entity;

/**
 * 对应car_t汽车表
 */
public class Car {
    private Integer carId;
    private String carType;
    private String carNumber;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carType='" + carType + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
