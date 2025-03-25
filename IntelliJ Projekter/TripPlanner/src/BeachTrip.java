class BeachTrip extends Trip {
    String hotelName;
    boolean allInclusive;
    int beachDays;

    BeachTrip(String destination, int duration, double price, String transport,
              String hotelName, boolean allInclusive, int beachDays) {
        super(destination, duration, price, transport);
        this.hotelName = hotelName;
        this.allInclusive = allInclusive;
        this.beachDays = beachDays;
    }

    void printDetails() {
        super.printDetails();
        System.out.println("Hotel: " + hotelName + ", All Inclusive: " + allInclusive +
                ", Beach Days: " + beachDays);
    }
}