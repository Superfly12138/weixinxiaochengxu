package com.superfly.cms.dao;

import com.superfly.cms.entity.RepairRegulations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RepairRegulationsDaoTest {
    @Autowired
    RepairRegulationsDao repairRegulationsDao;

    @Test
    public void queryRepairRegulations() {
        List<RepairRegulations> list = repairRegulationsDao.queryRepairRegulations();
        assertEquals(2,list.size());
    }

    @Test
    public void queryRepairRegulationsById() {
        RepairRegulations repairRegulations = repairRegulationsDao.queryRepairRegulationsById(5);
        assertEquals("补胎",repairRegulations.getRepairName());

    }

    @Test
    public void insertRepairRegulations() {
        RepairRegulations repairRegulations = new RepairRegulations();
        repairRegulations.setRepairName("te");
        repairRegulations.setRepairType("轮胎修理");
        repairRegulations.setRepairMoney("100");
        repairRegulations.setRepairInstruction(null);
        int effectedNum = repairRegulationsDao.insertRepairRegulations(repairRegulations);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateRepairRegulations() {
        RepairRegulations repairRegulations = new RepairRegulations();
        repairRegulations.setRepairId(5);
        repairRegulations.setRepairName("补胎");
        repairRegulations.setRepairType("轮胎修理");
        repairRegulations.setRepairMoney("60");
        repairRegulations.setRepairInstruction("修补轮胎");
        int effectedNum = repairRegulationsDao.updateRepairRegulations(repairRegulations);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteRepairRegulations() {
        int effectedNum =repairRegulationsDao.deleteRepairRegulations(6);
        assertEquals(1,effectedNum);
    }
}