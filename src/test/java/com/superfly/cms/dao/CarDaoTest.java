package com.superfly.cms.dao;

import com.superfly.cms.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarDaoTest {
    @Autowired
    private CarDao carDao;

    @Test
    public void queryCar() {
        List<Car> list = carDao.queryCar();
        assertEquals(2,list.size());
    }

    @Test
    public void queryCarById() {
        Car car = carDao.queryCarById(1);
        assertEquals("辽A-jjl",car.getCarNumber());
    }

    @Test
    public void insertCar() {
        Car car = new Car();
        car.setCarType("宝马S2");
        car.setCarNumber("辽A-jjhl");
        int effectedNum = carDao.insertCar(car);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateCar() {
        Car car = new Car();
        car.setCarId(1);
        car.setCarType("宝马S0");
        car.setCarNumber("辽A-jjml");
        int effectedNum = carDao.updateCar(car);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteCar() {
        int effectedNum = carDao.deleteCar(4);
        assertEquals(1,effectedNum);
    }
}