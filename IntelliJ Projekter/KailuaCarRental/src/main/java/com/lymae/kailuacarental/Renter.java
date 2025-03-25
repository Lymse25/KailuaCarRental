package com.lymae.kailuacarental;

public class Renter {
    private int renterID;
    private String name;
    private String address;
    private String zip;
    private String city;
    private String mobilePhone;
    private String phone;
    private String email;
    private String driverLicenseNumber;
    private String driverSince;

    public Renter(int renterID, String name, String address, String zip, String city, String mobilePhone, String phone, String email, String driverLicenseNumber, String driverSince) {
        this.renterID = renterID;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.phone = phone;
        this.email = email;
        this.driverLicenseNumber = driverLicenseNumber;
        this.driverSince = driverSince;
    }

    public int getRenterID() {
        return renterID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getDriverSince() {
        return driverSince;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "renterID=" + renterID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                ", driverSince='" + driverSince + '\'' +
                '}';
    }
}