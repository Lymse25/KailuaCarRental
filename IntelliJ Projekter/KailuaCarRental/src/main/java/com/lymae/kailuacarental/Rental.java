package com.lymae.kailuacarental;

import java.time.LocalDateTime;

public class Rental {
    private int rentalID;
    private Renter renter;
    private Car car;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private int maxKm;
    private int startKm;

    public Rental(int rentalID, Renter renter, Car car, LocalDateTime fromDateTime, LocalDateTime toDateTime, int maxKm, int startKm) {
        this.rentalID = rentalID;
        this.renter = renter;
        this.car = car;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.maxKm = maxKm;
        this.startKm = startKm;
    }

    public int getRentalID() {
        return rentalID;
    }

    public Renter getRenter() {
        return renter;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public int getStartKm() {
        return startKm;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalID=" + rentalID +
                ", renter=" + renter +
                ", car=" + car +
                ", fromDateTime=" + fromDateTime +
                ", toDateTime=" + toDateTime +
                ", maxKm=" + maxKm +
                ", startKm=" + startKm +
                '}';
    }
}