package com.superfly.cms.entity;

public class OtherCost {
    private Integer otherCostId;
    private String otherCostName;
    private String otherCostMoney;
    private String otherCostInstruction;

    public Integer getOtherCostId() {
        return otherCostId;
    }

    public void setOtherCostId(Integer otherCostId) {
        this.otherCostId = otherCostId;
    }

    public String getOtherCostName() {
        return otherCostName;
    }

    public void setOtherCostName(String otherCostName) {
        this.otherCostName = otherCostName;
    }

    public String getOtherCostInstruction() {
        return otherCostInstruction;
    }

    public void setOtherCostInstruction(String otherCostInstruction) {
        this.otherCostInstruction = otherCostInstruction;
    }

    public String getOtherCostMoney() {
        return otherCostMoney;
    }

    public void setOtherCostMoney(String otherCostMoney) {
        this.otherCostMoney = otherCostMoney;
    }

    @Override
    public String toString() {
        return "OtherCost{" +
                "otherCostId=" + otherCostId +
                ", otherCostName='" + otherCostName + '\'' +
                ", otherCostMoney='" + otherCostMoney + '\'' +
                ", otherCostInstruction='" + otherCostInstruction + '\'' +
                '}';
    }
}
