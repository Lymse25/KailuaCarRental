import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelSystem {
    private List<Guest> guests;
    private List<Room> rooms;
    private List<Reservation> reservations;
    private List<Rental> rentals;
    private List<Service> services;
    private List<PriceGroup> priceGroups;

    // Constructor
    public HotelSystem() {
        this.guests = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.rentals = new ArrayList<>();
        this.services = new ArrayList<>();
        this.priceGroups = new ArrayList<>();

        // Initialize some services
        services.add(new Service("Restaurant", 0));
        services.add(new Service("Minibar", 0));
        services.add(new Service("Phone", 0));
        services.add(new Service("Internet", 0));
    }

    // Guest methods
    public Guest createGuest(String name, String address, String email, String phoneNumber, String identification) {
        Guest guest = new Guest(name, address, email, phoneNumber, identification);
        guests.add(guest);
        return guest;
    }

    public Guest findGuestByEmail(String email) {
        return guests.stream()
                .filter(g -> g.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    // Room methods
    public Room createRoom(int roomNumber, int numberOfBeds, double price) {
        Room room = new Room(roomNumber, numberOfBeds, price);
        rooms.add(room);
        return room;
    }

    public Room findRoomByNumber(int roomNumber) {
        return rooms.stream()
                .filter(r -> r.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }

    public List<Room> getAvailableRooms(LocalDate fromDate, LocalDate toDate) {
        return rooms.stream()
                .filter(room -> isRoomAvailable(room, fromDate, toDate))
                .collect(Collectors.toList());
    }

    private boolean isRoomAvailable(Room room, LocalDate fromDate, LocalDate toDate) {
        return reservations.stream()
                .filter(r -> r.getRoom().equals(room))
                .noneMatch(r ->
                        (fromDate.isBefore(r.getToDate()) || fromDate.isEqual(r.getToDate())) &&
                                (toDate.isAfter(r.getFromDate()) || toDate.isEqual(r.getFromDate())));
    }

    // Reservation methods
    public Reservation createReservation(LocalDate fromDate, LocalDate toDate, Guest guest, Room room) {
        if (!isRoomAvailable(room, fromDate, toDate)) {
            throw new IllegalArgumentException("Room is not available for the selected dates");
        }

        Reservation reservation = new Reservation(fromDate, toDate, guest, room);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservationsByGuest(Guest guest) {
        return reservations.stream()
                .filter(r -> r.getGuest().equals(guest))
                .collect(Collectors.toList());
    }

    // Check-in methods
    public Rental checkIn(Reservation reservation) {
        Rental rental = new Rental(reservation.getRoom(), reservation.getGuest());
        rentals.add(rental);
        return rental;
    }

    public Rental checkIn(Guest guest, Room room) {
        Rental rental = new Rental(room, guest);
        rentals.add(rental);
        return rental;
    }

    // Check-out methods
    public double checkOut(Rental rental) {
        rental.checkOut();
        return rental.calculateTotalPrice();
    }

    // Service methods
    public Service findServiceByDescription(String description) {
        return services.stream()
                .filter(s -> s.getDescription().equals(description))
                .findFirst()
                .orElse(null);
    }

    public Purchase addPurchaseToRental(Rental rental, Service service, int quantity) {
        Purchase purchase = new Purchase(quantity, service, rental);
        rental.addPurchase(purchase);
        return purchase;
    }

    // Price group methods
    public PriceGroup createPriceGroup(String name) {
        PriceGroup priceGroup = new PriceGroup(name);
        priceGroups.add(priceGroup);
        return priceGroup;
    }

    // Getters
    public List<Guest> getGuests() { return guests; }
    public List<Room> getRooms() { return rooms; }
    public List<Reservation> getReservations() { return reservations; }
    public List<Rental> getRentals() { return rentals; }
    public List<Service> getServices() { return services; }
    public List<PriceGroup> getPriceGroups() { return priceGroups; }
}