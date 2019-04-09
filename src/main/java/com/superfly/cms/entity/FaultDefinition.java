package com.superfly.cms.entity;

public class FaultDefinition {
    private Integer faultId;
    private String faultName;
    private String faultType;
    private String faultInstruction;

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) {
        this.faultId = faultId;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getFaultInstruction() {
        return faultInstruction;
    }

    public void setFaultInstruction(String faultInstruction) {
        this.faultInstruction = faultInstruction;
    }

    @Override
    public String toString() {
        return "FaultDefinition{" +
                "faultId=" + faultId +
                ", faultName='" + faultName + '\'' +
                ", faultType='" + faultType + '\'' +
                ", faultInstruction='" + faultInstruction + '\'' +
                '}';
    }
}
