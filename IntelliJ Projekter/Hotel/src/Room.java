public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private double price;
    private PriceGroup priceGroup;

    // Constructor
    public Room(int roomNumber, int numberOfBeds, double price) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.price = price;
    }

    // Getters and setters
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public int getNumberOfBeds() { return numberOfBeds; }
    public void setNumberOfBeds(int numberOfBeds) { this.numberOfBeds = numberOfBeds; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public PriceGroup getPriceGroup() { return priceGroup; }
    public void setPriceGroup(PriceGroup priceGroup) { this.priceGroup = priceGroup; }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", numberOfBeds=" + numberOfBeds +
                ", price=" + price +
                '}';
    }
}