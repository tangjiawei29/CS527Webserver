package com.cs527.web.entity;


public class Aisles {

    private Long aisleId;
    private String aisle;

    @Override
    public String toString() {
        return "Aisles{" +
                "aisleId=" + aisleId +
                ", aisle='" + aisle + '\'' +
                '}';
    }

    public Long getAisleId() {
        return aisleId;
    }

    public void setAisleId(Long aisleId) {
        this.aisleId = aisleId;
    }


    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

}
