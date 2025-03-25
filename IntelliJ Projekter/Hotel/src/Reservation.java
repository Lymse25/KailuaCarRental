import java.time.LocalDate;

public class Reservation {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Guest guest;
    private Room room;

    // Constructor
    public Reservation(LocalDate fromDate, LocalDate toDate, Guest guest, Room room) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.guest = guest;
        this.room = room;
    }

    // Methods
    public int getNumberOfNights() {
        return (int) fromDate.until(toDate).getDays();
    }

    public double calculateTotalPrice() {
        return getNumberOfNights() * room.getPrice();
    }

    // Getters and setters
    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }

    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }

    public Guest getGuest() { return guest; }
    public void setGuest(Guest guest) { this.guest = guest; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    @Override
    public String toString() {
        return "Reservation{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", guest=" + guest +
                ", room=" + room +
                '}';
    }
}