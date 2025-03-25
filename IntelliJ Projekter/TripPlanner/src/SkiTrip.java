class SkiTrip extends Trip {
    String skiResort;
    int difficultyLevel;
    boolean equipmentRental;

    SkiTrip(String destination, int duration, double price, String transport,
            String skiResort, int difficultyLevel, boolean equipmentRental) {
        super(destination, duration, price, transport);
        this.skiResort = skiResort;
        this.difficultyLevel = difficultyLevel;
        this.equipmentRental = equipmentRental;
    }

    void printDetails() {
        super.printDetails();
        System.out.println("Ski Resort: " + skiResort + ", Difficulty: " + difficultyLevel +
                ", Equipment Rental: " + equipmentRental);
    }
}