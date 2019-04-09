package com.superfly.cms.dao;

import com.superfly.cms.entity.MaintainTeam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MaintainTeamDaoTest {

    @Autowired
    private MaintainTeamDao maintainTeamDao;

    @Test
    public void queryMaintainTeam() {
        List<MaintainTeam> list = maintainTeamDao.queryMaintainTeam();
        assertEquals(2,list.size());
    }

    @Test
    public void queryMaintainTeamById() {
        MaintainTeam maintainTeam = maintainTeamDao.queryMaintainTeamById(3);
        assertEquals("MB",maintainTeam.getMaintainTeamName());
    }

    @Test
    public void insertMaintainTeam() {
        MaintainTeam maintainTeam = new MaintainTeam();
        maintainTeam.setMaintainTeamName("MA");
        maintainTeam.setMaintainTeamInstruction("班组MA");
        int effectedNum = maintainTeamDao.insertMaintainTeam(maintainTeam);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateMaintainTeam() {
        MaintainTeam maintainTeam = new MaintainTeam();
        maintainTeam.setMaintainTeamId(3);
        maintainTeam.setMaintainTeamInstruction("B班组嗯");
        int effectedNum = maintainTeamDao.updateMaintainTeam(maintainTeam);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteMaintainTeam() {
        int effectedNum = maintainTeamDao.deleteMaintainTeam(1);
        assertEquals(1,effectedNum);
    }
}