package com.superfly.cms.dao;

import com.superfly.cms.entity.Fix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class FixDaoTest {
    @Autowired
    private FixDao fixDao;

    @Test
    public void queryFix() {
        List<Fix> list = fixDao.queryFix();
        assertEquals(2,list.size());
    }

    @Test
    public void queryFixByFixId() {
        Fix fix = fixDao.queryFixByFixId(1);
        assertEquals(new Integer(2),fix.getFaultId());

    }

    @Test
    public void insertFix() {
        Fix fix = new Fix();
//可为空的
//        fix.setFixActualMoney();
        fix.setFixOrderDate(new Date());
//可为空的
//        fix.setFixStartDate(new Date());
//可为空的
//        fix.setFixEndDate();
        fix.setFixOver(1);
//可为空的
//        fix.setRepairId();
        fix.setCarId(2);
//可为空的
//        fix.setRepairTeamId(1);
//可为空的
        fix.setFaultId(2);
//可为空的
//        fix.setOtherCostId();
        int effectedNum = fixDao.insertFix(fix);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateFix() {
        Fix fix = new Fix();
        fix.setFixId(1);
//可为空的
//        fix.setFixActualMoney();
//        fix.setFixOrderDate(new Date());
//可为空的
        fix.setFixStartDate(new Date());
//可为空的
//        fix.setFixEndDate();
        fix.setFixOver(1);
//可为空的
        fix.setRepairId(4);
        fix.setCarId(2);
//可为空的
        fix.setRepairTeamId(1);
//可为空的
        fix.setFaultId(2);
//可为空的
//        fix.setOtherCostId();
        int effectedNum = fixDao.updateFix(fix);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteFix() {
        int effectedNum = fixDao.deleteFix(3);
        assertEquals(1,effectedNum);
    }
}