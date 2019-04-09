package com.superfly.cms.dao;

import com.superfly.cms.entity.FaultDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest

public class FaultDefinitionDaoTest {
    @Autowired
    FaultDefinitionDao faultDefinitionDao;
    @Test
    public void queryFaultDefinition() {
       List<FaultDefinition> list =  faultDefinitionDao.queryFaultDefinition();
        assertEquals(2,list.size());
    }

    @Test
    public void queryFaultDefinitionById() {
       FaultDefinition faultDefinition =  faultDefinitionDao.queryFaultDefinitionById(1);
        assertEquals("缺少冷却液",faultDefinition.getFaultName());
    }

    @Test
    public void insertFaultDefinition() {
        FaultDefinition faultDefinition = new FaultDefinition();
        faultDefinition.setFaultName("轮胎漏气");
        faultDefinition.setFaultType("轮胎故障");
        faultDefinition.setFaultInstruction(null);
        int effectedNum = faultDefinitionDao.insertFaultDefinition(faultDefinition);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateFaultDefinition() {
        FaultDefinition faultDefinition = new FaultDefinition();
        faultDefinition.setFaultId(2);
        faultDefinition.setFaultName("轮胎漏气");
        faultDefinition.setFaultType("轮胎故障");
        faultDefinition.setFaultInstruction("轮胎不能正常工作");
        int effectedNum = faultDefinitionDao.updateFaultDefinition(faultDefinition);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteFaultDefinition() {
        int effectedNum = faultDefinitionDao.deleteFaultDefinition(3);
        assertEquals(1,effectedNum);
    }
}