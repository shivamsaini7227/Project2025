package com.example.myapplication2;


public class truckUserData extends userData {
    String truckBrand , licensePlate , truckType;
    truckUserData(){};

    public String getTruckBrand() {
        return truckBrand;
    }

    public void setTruckBrand(String truckBrand) {
        this.truckBrand = truckBrand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public truckUserData(String truckBrand , String licensePlate , String truckType) {
        this.truckBrand = truckBrand;
        this.licensePlate = licensePlate;
        this.truckType = truckType;
    }
}
