package com.superfly.cms.dao;

import com.superfly.cms.entity.Repairman;
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

public class RepairmanDaoTest {
    @Autowired
    private RepairmanDao repairmanDao;

    @Test
    public void queryRepairman() {
        List<Repairman> list =  repairmanDao.queryRepairman();
        assertEquals(3,list.size());
    }

    @Test
    public void queryRepairmanByRepairTeamId() {
        List<Repairman> list =  repairmanDao.queryRepairmanByRepairTeamId(1);
        assertEquals(2,list.size());
    }

    @Test
    public void queryRepairmanByMaintainTeamId() {
        List<Repairman> list =  repairmanDao.queryRepairmanByMaintainTeamId(4);
        assertEquals(1,list.size());
    }

    @Test
    public void queryRepairmanById() {
        Repairman repairman = repairmanDao.queryRepairmanById(2);
        assertEquals("test",repairman.getRepairmanName());
    }

    @Test
    public void insertRepairman() {
        Repairman repairman = new Repairman();
        repairman.setRepairmanPassword("admin");
        repairman.setRepairmanName("维修人员B");
        repairman.setRepairmanSex("男");
        repairman.setRepairmanAge(20);
        repairman.setRepairmanPhone("134567743274");
        repairman.setRepairmanAddress("上海");
        repairman.setRepairmanEmail("9032204476@qq.com");
        repairman.setRepairmanRegistrationDate(new Date());
        repairman.setRepairTeamId(null);
        repairman.setMaintainTeamId(4);
        // System.out.println(repairman);
        int effectedNum = repairmanDao.insertRepairman(repairman);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateRepairman() {
        Repairman repairman = new Repairman();
        repairman.setRepairmanId(2);
        repairman.setRepairmanPassword("admin");
        repairman.setRepairmanName("维修人员B");
        repairman.setRepairmanSex("男");
        repairman.setRepairmanAge(20);
        repairman.setRepairmanPhone("13453");
        repairman.setRepairmanAddress("上海");
        repairman.setRepairmanEmail("9036@qq.com");
//        repairman.setRepairmanRegistrationDate(new Date());
//        repairman.setRepairTeamId(1);
//        repairman.setMaintainTeamId(4);
        int effectedNum = repairmanDao.updateRepairman(repairman);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteRepairman() {
    }
}