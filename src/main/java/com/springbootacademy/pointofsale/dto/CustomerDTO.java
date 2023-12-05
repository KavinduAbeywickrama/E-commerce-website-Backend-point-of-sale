package com.springbootacademy.pointofsale.dto;

public class CustomerDTO {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private Double customerSalary;
    private String nic;
    private int contactNumber;
    private boolean activeStatus;

    public CustomerDTO(String customerName, String customerAddress, Double customerSalary, String nic, int contactNumber, boolean activeStatus) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.activeStatus = activeStatus;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String customerName, String customerAddress, Double customerSalary, String nic, int contactNumber, boolean activeStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.contactNumber = contactNumber;
        this.activeStatus = activeStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
