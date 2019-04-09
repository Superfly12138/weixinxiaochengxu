package com.superfly.cms.dao;

import com.superfly.cms.entity.OtherCost;
import com.superfly.cms.entity.RepairTeam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RepairTeamDaoTest {
    @Autowired
    private RepairTeamDao repairTeamDao;

    @Test
    public void queryRepairTeam() {
        List<RepairTeam> list = repairTeamDao.queryRepairTeam();
        assertEquals(2,list.size());
    }

    @Test
    public void queryRepairTeamById() {
        RepairTeam repairTeam = repairTeamDao.queryRepairTeamById(2);
        assertEquals("B",repairTeam.getRepairTeamName());
    }

    @Test
    public void insertRepairTeam() {
        RepairTeam repairTeam = new RepairTeam();
        repairTeam.setRepairTeamName("B");
        repairTeam.setRepairTeamInstruction("班组B");
        int effectedNum = repairTeamDao.insertRepairTeam(repairTeam);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateRepairTeam() {
        RepairTeam repairTeam = new RepairTeam();
        repairTeam.setRepairTeamId(2);
        repairTeam.setRepairTeamInstruction("B班组嗯");
        int effectedNum = repairTeamDao.updateRepairTeam(repairTeam);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteRepairTeam() {
        int effectedNum = repairTeamDao.deleteRepairTeam(2);
        assertEquals(1,effectedNum);
    }
}