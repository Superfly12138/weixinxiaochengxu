package com.superfly.cms.entity;

/**
 * 对应管理员表
 */
public class Admin {
    private Integer adminId;
    private String adminPassword;
    private String adminName;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }
}
