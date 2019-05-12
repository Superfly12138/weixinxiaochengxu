package com.superfly.cms.entity;

public class OwnRegulationsFix {
    private Integer ownId;
    private Integer repairId;
    private Integer fixId;

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    @Override
    public String toString() {
        return "OwnRegulationsFix{" +
                "ownId=" + ownId +
                ", repairId=" + repairId +
                ", fixId=" + fixId +
                '}';
    }
}
