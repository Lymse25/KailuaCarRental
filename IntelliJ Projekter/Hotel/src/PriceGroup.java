import java.util.ArrayList;
import java.util.List;

public class PriceGroup {
    private String name;
    private List<Double> prices;
    private List<Room> rooms;

    // Constructor
    public PriceGroup(String name) {
        this.name = name;
        this.prices = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    // Methods
    public void addPrice(double price) {
        prices.add(price);
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setPriceGroup(this);
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Double> getPrices() { return prices; }
    public void setPrices(List<Double> prices) { this.prices = prices; }

    public List<Room> getRooms() { return rooms; }
}