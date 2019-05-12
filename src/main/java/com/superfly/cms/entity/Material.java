package com.superfly.cms.entity;

public class Material {
    private Integer materialId;
    private String materialName;
    private Integer materialNumber;
    private String materialInmoney;
    private String materialOutmoney;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(Integer materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getMaterialInmoney() {
        return materialInmoney;
    }

    public void setMaterialInmoney(String materialInmoney) {
        this.materialInmoney = materialInmoney;
    }

    public String getMaterialOutmoney() {
        return materialOutmoney;
    }

    public void setMaterialOutmoney(String materialOutmoney) {
        this.materialOutmoney = materialOutmoney;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                ", materialNumber=" + materialNumber +
                ", materialInmoney='" + materialInmoney + '\'' +
                ", materialOutmoney='" + materialOutmoney + '\'' +
                '}';
    }
}
