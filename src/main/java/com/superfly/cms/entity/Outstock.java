package com.superfly.cms.entity;

import java.util.Date;

public class Outstock {
    private Integer outstockId;
    private Integer materialId;
    private Integer outstockNumber;
    private Date outstockTime;

    private Integer summeroutstock;

    private String materialName;
    private String inMoney;
    private String outMoney;

    public Integer getSummeroutstock() {
        return summeroutstock;
    }

    public void setSummeroutstock(Integer summeroutstock) {
        this.summeroutstock = summeroutstock;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getInMoney() {
        return inMoney;
    }

    public void setInMoney(String inMoney) {
        this.inMoney = inMoney;
    }

    public String getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(String outMoney) {
        this.outMoney = outMoney;
    }

    public Integer getOutstockId() {
        return outstockId;
    }

    public void setOutstockId(Integer outstockId) {
        this.outstockId = outstockId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getOutstockNumber() {
        return outstockNumber;
    }

    public void setOutstockNumber(Integer outstockNumber) {
        this.outstockNumber = outstockNumber;
    }

    public Date getOutstockTime() {
        return outstockTime;
    }

    public void setOutstockTime(Date outstockTime) {
        this.outstockTime = outstockTime;
    }

    @Override
    public String toString() {
        return "Outstock{" +
                "outstockId=" + outstockId +
                ", materialId=" + materialId +
                ", outstockNumber=" + outstockNumber +
                ", outstockTime=" + outstockTime +
                ", summeroutstock=" + summeroutstock +
                ", materialName='" + materialName + '\'' +
                ", inMoney='" + inMoney + '\'' +
                ", outMoney='" + outMoney + '\'' +
                '}';
    }
}
