package com.superfly.cms.entity;

import java.util.Date;

public class Instock {
    private Integer instockId;
    private Integer materialId;
    private Integer instockNumber;
    private Date instockTime;

    private Integer summerinstock;

    private String materialName;
    private String inMoney;
    private String outMoney;

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

    public Integer getSummerinstock() {
        return summerinstock;
    }

    public void setSummerinstock(Integer summerinstock) {
        this.summerinstock = summerinstock;
    }

    public Integer getInstockId() {
        return instockId;
    }

    public void setInstockId(Integer instockId) {
        this.instockId = instockId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getInstockNumber() {
        return instockNumber;
    }

    public void setInstockNumber(Integer instockNumber) {
        this.instockNumber = instockNumber;
    }

    public Date getInstockTime() {
        return instockTime;
    }

    public void setInstockTime(Date instockTime) {
        this.instockTime = instockTime;
    }

    @Override
    public String toString() {
        return "Instock{" +
                "instockId=" + instockId +
                ", materialId=" + materialId +
                ", instockNumber=" + instockNumber +
                ", instockTime=" + instockTime +
                ", summerinstock=" + summerinstock +
                ", materialName='" + materialName + '\'' +
                ", inMoney='" + inMoney + '\'' +
                ", outMoney='" + outMoney + '\'' +
                '}';
    }
}
