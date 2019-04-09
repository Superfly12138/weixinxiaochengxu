package com.superfly.cms.dao;

import com.superfly.cms.entity.OtherCost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest

public class OtherCostDaoTest {
    @Autowired
    OtherCostDao otherCostDao;

    @Test
    public void queryOtherCost() {
        List<OtherCost> list = otherCostDao.queryOtherCost();
        assertEquals(1,list.size());
    }

    @Test
    public void queryOtherCostById() {
        OtherCost otherCost = otherCostDao.queryOtherCostById(2);
        assertEquals("更换车垫",otherCost.getOtherCostName());
    }

    @Test
    public void insertOtherCost() {
        OtherCost otherCost = new OtherCost();
        otherCost.setOtherCostName("更换车垫");
        otherCost.setOtherCostInstruction("更换车垫很方便，代价很小");
        int effectedNum = otherCostDao.insertOtherCost(otherCost);
        assertEquals(1,effectedNum);

    }

    @Test
    public void updateOtherCost() {
        OtherCost otherCost = new OtherCost();
        otherCost.setOtherCostId(2);
        otherCost.setOtherCostInstruction("更换车垫很方便，代价很小。");
        int effectedNum = otherCostDao.updateOtherCost(otherCost);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteOtherCost() {
        int effectedNum = otherCostDao.deleteOtherCost(1);
        assertEquals(1,effectedNum);
    }
}