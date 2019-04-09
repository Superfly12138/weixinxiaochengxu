package com.superfly.cms.dao;

import com.superfly.cms.entity.OwnCusCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnCusCarDaoTest {
    @Autowired
    private OwnCusCarDao ownCusCarDao;

    @Test
    public void queryOwnCusCar() {
       List<OwnCusCar> list = ownCusCarDao.queryOwnCusCar();
        assertEquals(3,list.size());
    }

    @Test
    public void queryOwnCusCarByCusId() {
        List<OwnCusCar> list = ownCusCarDao.queryOwnCusCarByCusId(3);
        assertEquals(2,list.size());
    }

    @Test
    public void queryOwnCusCarByCarId() {
        OwnCusCar ownCusCar = ownCusCarDao.queryOwnCusCarByCarId(1);
//        System.out.println(ownCusCar.getCusId());
        assertEquals(new Integer(1),ownCusCar.getCarId());
    }

    @Test
    public void insertOwnCusCar() {
        OwnCusCar ownCusCar = new OwnCusCar();
        ownCusCar.setCusId(6);
        //实际情况下应先添加car_t数据，然后将id带回
        ownCusCar.setCarId(4);
        int effectedNum = ownCusCarDao.insertOwnCusCar(ownCusCar);
        assertEquals(1,effectedNum);
    }

    //暂时没用
    @Test
    public void updateOwnCusCar() {
    }

    @Test
    public void deleteOwnCusCar() {
        int effectedNum = ownCusCarDao.deleteOwnCusCar(6);
        assertEquals(1,effectedNum);
    }
}