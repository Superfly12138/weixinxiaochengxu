package com.superfly.cms.entity;

public class OwnMaterialFix {
    private Integer ownId;
    private Integer materialId;
    private Integer fixId;
    private Integer ownMaterialFixNumber;

    private String materialName;
    private Integer materialsummer;
    private String materialInMoney;
    private String materialOutMoney;

    public Integer getOwnMaterialFixNumber() {
        return ownMaterialFixNumber;
    }

    public void setOwnMaterialFixNumber(Integer ownMaterialFixNumber) {
        this.ownMaterialFixNumber = ownMaterialFixNumber;
    }

    public Integer getOwnId() {
        return ownId;
    }

    public void setOwnId(Integer ownId) {
        this.ownId = ownId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getFixId() {
        return fixId;
    }

    public void setFixId(Integer fixId) {
        this.fixId = fixId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getMaterialsummer() {
        return materialsummer;
    }

    public void setMaterialsummer(Integer materialsummer) {
        this.materialsummer = materialsummer;
    }

    public String getMaterialInMoney() {
        return materialInMoney;
    }

    public void setMaterialInMoney(String materialInMoney) {
        this.materialInMoney = materialInMoney;
    }

    public String getMaterialOutMoney() {
        return materialOutMoney;
    }

    public void setMaterialOutMoney(String materialOutMoney) {
        this.materialOutMoney = materialOutMoney;
    }

    @Override
    public String toString() {
        return "OwnMaterialFix{" +
                "ownId=" + ownId +
                ", materialId=" + materialId +
                ", fixId=" + fixId +
                ", ownMaterialFixNumber=" + ownMaterialFixNumber +
                ", materialName='" + materialName + '\'' +
                ", materialsummer=" + materialsummer +
                ", materialInMoney='" + materialInMoney + '\'' +
                ", materialOutMoney='" + materialOutMoney + '\'' +
                '}';
    }
}
