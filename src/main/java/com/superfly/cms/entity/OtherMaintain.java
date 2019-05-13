package com.superfly.cms.entity;

public class OtherMaintain {
    private Integer otherMaintainId;
    private String otherMaintainName;
    private String otherMaintainMoney;
    private String otherMaintainInstruction;

    public Integer getOtherMaintainId() {
        return otherMaintainId;
    }

    public void setOtherMaintainId(Integer otherMaintainId) {
        this.otherMaintainId = otherMaintainId;
    }

    public String getOtherMaintainName() {
        return otherMaintainName;
    }

    public void setOtherMaintainName(String otherMaintainName) {
        this.otherMaintainName = otherMaintainName;
    }

    public String getOtherMaintainInstruction() {
        return otherMaintainInstruction;
    }

    public void setOtherMaintainInstruction(String otherMaintainInstruction) {
        this.otherMaintainInstruction = otherMaintainInstruction;
    }

    public String getOtherMaintainMoney() {
        return otherMaintainMoney;
    }

    public void setOtherMaintainMoney(String otherMaintainMoney) {
        this.otherMaintainMoney = otherMaintainMoney;
    }

    @Override
    public String toString() {
        return "OtherMaintain{" +
                "otherMaintainId=" + otherMaintainId +
                ", otherMaintainName='" + otherMaintainName + '\'' +
                ", otherMaintainMoney='" + otherMaintainMoney + '\'' +
                ", otherMaintainInstruction='" + otherMaintainInstruction + '\'' +
                '}';
    }
}
