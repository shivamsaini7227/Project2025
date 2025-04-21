package com.example.myapplication2;

public class userData {
    String name , phoneNumber , address , adhaar , license;
    userData(){}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public userData(String name, String phoneNumber, String address, String driverAdhaar, String driverLicense) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        adhaar = driverAdhaar;
        license = driverLicense;

    }

}
