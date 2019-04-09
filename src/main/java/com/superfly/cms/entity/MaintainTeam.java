package com.superfly.cms.entity;

public class MaintainTeam {
    private Integer maintainTeamId;
    private String maintainTeamName;
    private String maintainTeamInstruction;

    public Integer getMaintainTeamId() {
        return maintainTeamId;
    }

    public void setMaintainTeamId(Integer maintainTeamId) {
        this.maintainTeamId = maintainTeamId;
    }

    public String getMaintainTeamName() {
        return maintainTeamName;
    }

    public void setMaintainTeamName(String maintainTeamName) {
        this.maintainTeamName = maintainTeamName;
    }

    public String getMaintainTeamInstruction() {
        return maintainTeamInstruction;
    }

    public void setMaintainTeamInstruction(String maintainTeamInstruction) {
        this.maintainTeamInstruction = maintainTeamInstruction;
    }

    @Override
    public String toString() {
        return "MaintainTeam{" +
                "maintainTeamId=" + maintainTeamId +
                ", maintainTeamName='" + maintainTeamName + '\'' +
                ", maintainTeamInstruction='" + maintainTeamInstruction + '\'' +
                '}';
    }
}
