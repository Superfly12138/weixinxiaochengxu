package com.superfly.cms.entity;

public class OwnMaterialFix {
    private Integer ownId;
    private Integer materialId;
    private Integer fixId;
    private Integer ownMaterialFixNumber;

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

    @Override
    public String toString() {
        return "OwnMaterialFix{" +
                "ownId=" + ownId +
                ", materialId=" + materialId +
                ", fixId=" + fixId +
                ", ownMaterialFixNumber=" + ownMaterialFixNumber +
                '}';
    }
}
