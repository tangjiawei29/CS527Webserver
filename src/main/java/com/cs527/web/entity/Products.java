package com.cs527.web.entity;


public class Products {

    private Long productId;
    private String productName;
    private Long aisleId;
    private Long departmentId;

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", aisleId=" + aisleId +
                ", departmentId=" + departmentId +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Long getAisleId() {
        return aisleId;
    }

    public void setAisleId(Long aisleId) {
        this.aisleId = aisleId;
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

}
