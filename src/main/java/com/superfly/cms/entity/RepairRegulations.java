package com.superfly.cms.entity;

public class RepairRegulations {
    private Integer repairId;
    private String repairName;
    private String repairType;
    private String repairMoney;
    private String repairInstruction;

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getRepairMoney() {
        return repairMoney;
    }

    public void setRepairMoney(String repairMoney) {
        this.repairMoney = repairMoney;
    }

    public String getRepairInstruction() {
        return repairInstruction;
    }

    public void setRepairInstruction(String repairInstruction) {
        this.repairInstruction = repairInstruction;
    }

    @Override
    public String toString() {
        return "RepairRegulations{" +
                "repairId=" + repairId +
                ", repairName='" + repairName + '\'' +
                ", repairType='" + repairType + '\'' +
                ", repairMoney='" + repairMoney + '\'' +
                ", repairInstruction='" + repairInstruction + '\'' +
                '}';
    }
}
