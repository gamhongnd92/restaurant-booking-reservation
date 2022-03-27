package com.csis3275.group4.entity;

public class Customer {
    private String customerName;
    private String customerPhone;

    protected Customer() {}

    public Customer(String Customer_Name, String Customer_Phone){
        this.customerName = Customer_Name;
        this.customerPhone = Customer_Phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
