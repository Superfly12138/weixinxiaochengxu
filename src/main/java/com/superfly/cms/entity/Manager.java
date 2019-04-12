package com.superfly.cms.entity;

import java.util.Date;
/**
 * 对应manager_t用户表
 */
public class Manager {
    private Integer managerId;
    private String managerPassword;
    private String managerName;
    private String managerSex;
    private Integer managerAge;
    private String managerPhone;
    private String managerAddress;
    private String managerEmail;
    private Date managerRegistrationDate;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerSex() {
        return managerSex;
    }

    public void setManagerSex(String managerSex) {
        this.managerSex = managerSex;
    }

    public Integer getManagerAge() {
        return managerAge;
    }

    public void setManagerAge(Integer managerAge) {
        this.managerAge = managerAge;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerAddress() {
        return managerAddress;
    }

    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public Date getManagerRegistrationDate() {
        return managerRegistrationDate;
    }

    public void setManagerRegistrationDate(Date managerRegistrationDate) {
        this.managerRegistrationDate = managerRegistrationDate;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", managerPassword='" + managerPassword + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerSex='" + managerSex + '\'' +
                ", managerAge=" + managerAge +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerAddress='" + managerAddress + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", managerRegistrationDate=" + managerRegistrationDate +
                '}';
    }
}
