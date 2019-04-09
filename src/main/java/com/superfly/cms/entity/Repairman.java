package com.superfly.cms.entity;

import java.util.Date;

public class Repairman {
    private Integer repairmanId;
    private String repairmanPassword;
    private String repairmanName;
    private String repairmanSex;
    private Integer repairmanAge;
    private String repairmanPhone;
    private String repairmanAddress;
    private String repairmanEmail;
    private Date repairmanRegistrationDate;
    private Integer repairTeamId;
    private Integer maintainTeamId;

    public Integer getRepairmanId() {
        return repairmanId;
    }

    public void setRepairmanId(Integer repairmanId) {
        this.repairmanId = repairmanId;
    }

    public String getRepairmanPassword() {
        return repairmanPassword;
    }

    public void setRepairmanPassword(String repairmanPassword) {
        this.repairmanPassword = repairmanPassword;
    }

    public String getRepairmanName() {
        return repairmanName;
    }

    public void setRepairmanName(String repairmanName) {
        this.repairmanName = repairmanName;
    }

    public String getRepairmanSex() {
        return repairmanSex;
    }

    public void setRepairmanSex(String repairmanSex) {
        this.repairmanSex = repairmanSex;
    }

    public Integer getRepairmanAge() {
        return repairmanAge;
    }

    public void setRepairmanAge(Integer repairmanAge) {
        this.repairmanAge = repairmanAge;
    }

    public String getRepairmanPhone() {
        return repairmanPhone;
    }

    public void setRepairmanPhone(String repairmanPhone) {
        this.repairmanPhone = repairmanPhone;
    }

    public String getRepairmanAddress() {
        return repairmanAddress;
    }

    public void setRepairmanAddress(String repairmanAddress) {
        this.repairmanAddress = repairmanAddress;
    }

    public String getRepairmanEmail() {
        return repairmanEmail;
    }

    public void setRepairmanEmail(String repairmanEmail) {
        this.repairmanEmail = repairmanEmail;
    }

    public Date getRepairmanRegistrationDate() {
        return repairmanRegistrationDate;
    }

    public void setRepairmanRegistrationDate(Date repairmanRegistrationDate) {
        this.repairmanRegistrationDate = repairmanRegistrationDate;
    }

    public Integer getRepairTeamId() {
        return repairTeamId;
    }

    public void setRepairTeamId(Integer repairTeamId) {
        this.repairTeamId = repairTeamId;
    }

    public Integer getMaintainTeamId() {
        return maintainTeamId;
    }

    public void setMaintainTeamId(Integer maintainTeamId) {
        this.maintainTeamId = maintainTeamId;
    }

    @Override
    public String toString() {
        return "Repairman{" +
                "repairmanId=" + repairmanId +
                ", repairmanPassword='" + repairmanPassword + '\'' +
                ", repairmanName='" + repairmanName + '\'' +
                ", repairmanSex='" + repairmanSex + '\'' +
                ", repairmanAge='" + repairmanAge + '\'' +
                ", repairmanPhone='" + repairmanPhone + '\'' +
                ", repairmanAddress='" + repairmanAddress + '\'' +
                ", repairmanEmail='" + repairmanEmail + '\'' +
                ", repairmanRegistrationDate=" + repairmanRegistrationDate +
                ", repairTeamId=" + repairTeamId +
                ", maintainTeamId=" + maintainTeamId +
                '}';
    }
}
