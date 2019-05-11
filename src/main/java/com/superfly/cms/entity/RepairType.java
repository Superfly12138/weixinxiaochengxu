package com.superfly.cms.entity;

public class RepairType {
    private Integer repairTypeId;
    private String repairTypeName;
    private String repairTypeInstruction;

    public Integer getRepairTypeId() {
        return repairTypeId;
    }

    public void setRepairTypeId(Integer repairTypeId) {
        this.repairTypeId = repairTypeId;
    }

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }

    public String getRepairTypeInstruction() {
        return repairTypeInstruction;
    }

    public void setRepairTypeInstruction(String repairTypeInstruction) {
        this.repairTypeInstruction = repairTypeInstruction;
    }

    @Override
    public String toString() {
        return "RepairType{" +
                "repairTypeId=" + repairTypeId +
                ", repairTypeName='" + repairTypeName + '\'' +
                ", repairTypeInstruction='" + repairTypeInstruction + '\'' +
                '}';
    }
}
