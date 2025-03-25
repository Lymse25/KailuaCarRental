class Trip {
    String destination;
    int duration;
    double price;
    String transport;

    Trip(String destination, int duration, double price, String transport) {
        this.destination = destination;
        this.duration = duration;
        this.price = price;
        this.transport = transport;
    }

    void printDetails() {
        System.out.println(destination + " (" + duration + " days, " + price + " DKK, " + transport + ")");
    }
}