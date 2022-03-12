package com.cs527.web.entity;
import java.io.Serializable;


public class Customer implements Serializable{
    private int CustomerID;
    private String Customer_ContactName;
    private String Customer_Phone;
    private String CompanyName;

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID=" + CustomerID +
                ", Customer_ContactName='" + Customer_ContactName + '\'' +
                ", Customer_Phone='" + Customer_Phone + '\'' +
                ", CompanyName='" + CompanyName + '\'' +
                ", PlaceId=" + PlaceId +
                '}';
    }

    private int PlaceId;

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomer_ContactName() {
        return Customer_ContactName;
    }

    public void setCustomer_ContactName(String customer_ContactName) {
        Customer_ContactName = customer_ContactName;
    }

    public String getCustomer_Phone() {
        return Customer_Phone;
    }

    public void setCustomer_Phone(String customer_Phone) {
        Customer_Phone = customer_Phone;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        PlaceId = placeId;
    }


}