package com.lymae.kailuacarental;

public class Car {
    private String regNumber;
    private String brandModel;
    private String fuelType;
    private int firstRegYear;
    private int firstRegMonth;
    private int odometer;
    private CarCategory category;

    public Car(String regNumber, String brandModel, String fuelType, int firstRegYear, int firstRegMonth, int odometer, CarCategory category) {
        this.regNumber = regNumber;
        this.brandModel = brandModel;
        this.fuelType = fuelType;
        this.firstRegYear = firstRegYear;
        this.firstRegMonth = firstRegMonth;
        this.odometer = odometer;
        this.category = category;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getFirstRegYear() {
        return firstRegYear;
    }

    public int getFirstRegMonth() {
        return firstRegMonth;
    }

    public int getOdometer() {
        return odometer;
    }

    public CarCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", brandModel='" + brandModel + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", firstRegYear=" + firstRegYear +
                ", firstRegMonth=" + firstRegMonth +
                ", odometer=" + odometer +
                ", category=" + category +
                '}';
    }
}