package com.superfly.cms.entity;

public class RepairTeam {
    private Integer repairTeamId;
    private String repairTeamName;
    private String repairTeamInstruction;

    public Integer getRepairTeamId() {
        return repairTeamId;
    }

    public void setRepairTeamId(Integer repairTeamId) {
        this.repairTeamId = repairTeamId;
    }

    public String getRepairTeamName() {
        return repairTeamName;
    }

    public void setRepairTeamName(String repairTeamName) {
        this.repairTeamName = repairTeamName;
    }

    public String getRepairTeamInstruction() {
        return repairTeamInstruction;
    }

    public void setRepairTeamInstruction(String repairTeamInstruction) {
        this.repairTeamInstruction = repairTeamInstruction;
    }

    @Override
    public String toString() {
        return "RepairTeam{" +
                "repairTeamId=" + repairTeamId +
                ", repairTeamName='" + repairTeamName + '\'' +
                ", repairTeamInstruction='" + repairTeamInstruction + '\'' +
                '}';
    }
}
