package com.superfly.cms.entity;

import java.util.Date;
import java.util.List;

public class Fix {
    private Integer fixId;
    private Integer cusId;
    private Integer carId;
    private Integer faultId;
    private Integer repairTypeId;
    private Integer repairTeamId;
    private Integer repairId;
    private Integer otherCostId;
    private Date nextMaintainDate;
    private Date fixOrderDate;
    private Date fixEndDate;
    private Integer fixOver;

    private String cusName;
    private String cusSex;
    private String cusPhone;
    private String cusAddress;

    private String carType;
    private String carNumber;

    private String faultName;

    private String repairTypeName;

    private String repairName;
    private String repairMoney;

    private String repairTeamName;

    private String otherCostName;
    private String otherCostMoney;

    private String fixStatus;
    private Integer summerMoney;

    private List<RepairRegulations> repairRegulationsList;
    private List<Material> materialList;

    public List<RepairRegulations> getRepairRegulationsList() {
        return repairRegulationsList;
    }

    public void setRepairRegulationsList(List<RepairRegulations> repairRegulationsList) {
        this.repairRegulationsList = repairRegulationsList;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public String getCusSex() {
        return cusSex;
    }

    public String getOtherCostMoney() {
        return otherCostMoney;
    }

    public void setOtherCostMoney(String otherCostMoney) {
        this.otherCostMoney = otherCostMoney;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getRepairTypeName() {
        return repairTypeName;
    }

    public void setRepairTypeName(String repairTypeName) {
        this.repairTypeName = repairTypeName;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getRepairMoney() {
        return repairMoney;
    }

    public void setRepairMoney(String repairMoney) {
        this.repairMoney = repairMoney;
    }

    public String getRepairTeamName() {
        return repairTeamName;
    }

    public void setRepairTeamName(String repairTeamName) {
        this.repairTeamName = repairTeamName;
    }

    public String getOtherCostName() {
        return otherCostName;
    }

    public void setOtherCostName(String otherCostName) {
        this.otherCostName = otherCostName;
    }



    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getFaultId() {
        return faultId;
    }

    public void setFaultId(Integer faultId) {
        this.faultId = faultId;
    }

    public Integer getRepairTypeId() {
        return repairTypeId;
    }

    public void setRepairTypeId(Integer repairTypeId) {
        this.repairTypeId = repairTypeId;
    }

    public Integer getRepairTeamId() {
        return repairTeamId;
    }

    public void setRepairTeamId(Integer repairTeamId) {
        this.repairTeamId = repairTeamId;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getOtherCostId() {
        return otherCostId;
    }

    public void setOtherCostId(Integer otherCostId) {
        this.otherCostId = otherCostId;
    }

    public Date getNextMaintainDate() {
        return nextMaintainDate;
    }

    public void setNextMaintainDate(Date nextMaintainDate) {
        this.nextMaintainDate = nextMaintainDate;
    }

    public Date getFixOrderDate() {
        return fixOrderDate;
    }

    public void setFixOrderDate(Date fixOrderDate) {
        this.fixOrderDate = fixOrderDate;
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

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFixStatus() {
        return fixStatus;
    }

    public void setFixStatus(String fixStatus) {
        this.fixStatus = fixStatus;
    }

    public Integer getSummerMoney() {
        return summerMoney;
    }

    public void setSummerMoney(Integer summerMoney) {
        this.summerMoney = summerMoney;
    }

    @Override
    public String toString() {
        return "Fix{" +
                "fixId=" + fixId +
                ", cusId=" + cusId +
                ", carId=" + carId +
                ", faultId=" + faultId +
                ", repairTypeId=" + repairTypeId +
                ", repairTeamId=" + repairTeamId +
                ", repairId=" + repairId +
                ", otherCostId=" + otherCostId +
                ", nextMaintainDate=" + nextMaintainDate +
                ", fixOrderDate=" + fixOrderDate +
                ", fixEndDate=" + fixEndDate +
                ", fixOver=" + fixOver +
                ", cusName='" + cusName + '\'' +
                ", cusSex='" + cusSex + '\'' +
                ", cusPhone='" + cusPhone + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", carType='" + carType + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", faultName='" + faultName + '\'' +
                ", repairTypeName='" + repairTypeName + '\'' +
                ", repairName='" + repairName + '\'' +
                ", repairMoney='" + repairMoney + '\'' +
                ", repairTeamName='" + repairTeamName + '\'' +
                ", otherCostName='" + otherCostName + '\'' +
                ", otherCostMoney='" + otherCostMoney + '\'' +
                ", fixStatus='" + fixStatus + '\'' +
                ", summerMoney=" + summerMoney +
                ", repairRegulationsList=" + repairRegulationsList +
                ", materialList=" + materialList +
                '}';
    }
}
