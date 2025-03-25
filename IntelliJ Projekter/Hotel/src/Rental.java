import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Rental {
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Room room;
    private Guest guest;
    private List<Purchase> purchases;

    // Constructor
    public Rental(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
        this.purchases = new ArrayList<>();
        this.checkIn = LocalDateTime.now();
    }

    // Methods
    public void addPurchase(Purchase purchase) {
        purchases.add(purchase);
        purchase.setRental(this);
    }

    public void checkOut() {
        this.checkOut = LocalDateTime.now();
    }

    public double calculateTotalPrice() {
        double roomPrice = room.getPrice() * getDaysStayed();
        double purchasesPrice = purchases.stream()
                .mapToDouble(Purchase::calculateTotal)
                .sum();
        return roomPrice + purchasesPrice;
    }

    private int getDaysStayed() {
        if (checkOut == null) {
            return 0;
        }
        return (int) checkIn.toLocalDate().until(checkOut.toLocalDate()).getDays() + 1;
    }

    // Getters and setters
    public LocalDateTime getCheckIn() { return checkIn; }
    public void setCheckIn(LocalDateTime checkIn) { this.checkIn = checkIn; }

    public LocalDateTime getCheckOut() { return checkOut; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

    public List<Purchase> getPurchases() { return purchases; }

    @Override
    public String toString() {
        return "Rental{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", room=" + room +
                ", guest=" + guest +
                '}';
    }
}