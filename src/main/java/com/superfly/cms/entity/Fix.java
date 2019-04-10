package com.superfly.cms.entity;

import java.util.Date;

public class Fix {
    private Integer fixId;
    private String fixActualMoney;
    private Date fixOrderDate;
    private Date fixStartDate;
    private Date fixEndDate;
    private Integer fixOver;
    private Integer repairId;
    private Integer carId;
    private Integer repairTeamId;
    private Integer faultId;
    private Integer otherCostId;

    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    public String getFixActualMoney() {
        return fixActualMoney;
    }

    public void setFixActualMoney(String fixActualMoney) {
        this.fixActualMoney = fixActualMoney;
    }

    public Date getFixOrderDate() {
        return fixOrderDate;
    }

    public void setFixOrderDate(Date fixOrderDate) {
        this.fixOrderDate = fixOrderDate;
    }

    public Date getFixStartDate() {
        return fixStartDate;
    }

    public void setFixStartDate(Date fixStartDate) {
        this.fixStartDate = fixStartDate;
    }

    public Date getFixEndDate() {
        return fixEndDate;
    }

    public void setFixEndDate(Date fixEndDate) {
        this.fixEndDate = fixEndDate;
    }

    public Integer getFixOver() {
        return fixOver;
    }

    public void setFixOver(Integer fixOver) {
        this.fixOver = fixOver;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getRepairTeamId() {
        return repairTeamId;
    }

    public void setRepairTeamId(Integer repairTeamId) {
        this.repairTeamId = repairTeamId;
    }

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) {
        this.faultId = faultId;
    }

    public Integer getOtherCostId() {
        return otherCostId;
    }

    public void setOtherCostId(Integer otherCostId) {
        this.otherCostId = otherCostId;
    }

    @Override
    public String toString() {
        return "Fix{" +
                "fixId=" + fixId +
                ", fixActualMoney='" + fixActualMoney + '\'' +
                ", fixOrderDate=" + fixOrderDate +
                ", fixStartDate=" + fixStartDate +
                ", fixEndDate=" + fixEndDate +
                ", fixOver=" + fixOver +
                ", repairId=" + repairId +
                ", carId=" + carId +
                ", repairTeamId=" + repairTeamId +
                ", faultId=" + faultId +
                ", otherCostId=" + otherCostId +
                '}';
    }
}
