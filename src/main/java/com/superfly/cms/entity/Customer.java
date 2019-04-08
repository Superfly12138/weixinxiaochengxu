package com.superfly.cms.entity;

import java.util.Date;

/**
 * 对应customer_t用户表
 */

public class Customer {
    private Integer cusId;
    private String cusPassword;
    private String cusName;
    private String cusSex;
    private Integer cusAge;
    private String cusPhone;
    private String cusAddress;
    private String cusEmail;
    private Date cusRegistrationDate;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusSex() {
        return cusSex;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public Integer getCusAge() {
        return cusAge;
    }

    public void setCusAge(Integer cusAge) {
        this.cusAge = cusAge;
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

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public Date getCusRegistrationDate() {
        return cusRegistrationDate;
    }

    public void setCusRegistrationDate(Date cusRegistrationDate) {
        this.cusRegistrationDate = cusRegistrationDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusPassword='" + cusPassword + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusSex='" + cusSex + '\'' +
                ", cusAge=" + cusAge +
                ", cusPhone='" + cusPhone + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusEmail='" + cusEmail + '\'' +
                ", cusRegistrationDate=" + cusRegistrationDate +
                '}';
    }
}
