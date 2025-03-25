import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ReservationController {
    private HotelSystem hotelSystem;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ReservationController(HotelSystem hotelSystem) {
        this.hotelSystem = hotelSystem;
        this.scanner = new Scanner(System.in);
    }

    public void makeReservation() {
        System.out.println("\n=== MAKE RESERVATION ===");

        // Get guest details
        Guest guest = findOrCreateGuest();

        // Get dates
        System.out.print("Enter check-in date (dd-MM-yyyy): ");
        LocalDate fromDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

        System.out.print("Enter check-out date (dd-MM-yyyy): ");
        LocalDate toDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

        // Show available rooms
        List<Room> availableRooms = hotelSystem.getAvailableRooms(fromDate, toDate);

        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available for the selected dates.");
            return;
        }

        System.out.println("\nAvailable rooms:");
        for (int i = 0; i < availableRooms.size(); i++) {
            Room room = availableRooms.get(i);
            System.out.printf("%d. Room %d - %d beds - %.2f kr per night%n",
                    i + 1, room.getRoomNumber(), room.getNumberOfBeds(), room.getPrice());
        }

        // Select room
        System.out.print("\nSelect room number (1-" + availableRooms.size() + "): ");
        int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Room selectedRoom = availableRooms.get(roomIndex);

        // Create reservation
        Reservation reservation = hotelSystem.createReservation(fromDate, toDate, guest, selectedRoom);

        // Display confirmation
        System.out.println("\nReservation confirmed:");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room: " + selectedRoom.getRoomNumber());
        System.out.println("Check-in: " + reservation.getFromDate().format(dateFormatter));
        System.out.println("Check-out: " + reservation.getToDate().format(dateFormatter));
        System.out.println("Total nights: " + reservation.getNumberOfNights());
        System.out.printf("Total price: %.2f kr%n", reservation.calculateTotalPrice());
    }

    private Guest findOrCreateGuest() {
        System.out.print("Enter guest email: ");
        String email = scanner.nextLine();

        Guest guest = hotelSystem.findGuestByEmail(email);

        if (guest == null) {
            System.out.println("Guest not found. Please enter guest details:");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            System.out.print("Phone number: ");
            String phoneNumber = scanner.nextLine();

            System.out.print("Identification (passport/ID): ");
            String identification = scanner.nextLine();

            guest = hotelSystem.createGuest(name, address, email, phoneNumber, identification);
            System.out.println("Guest created successfully.");
        } else {
            System.out.println("Guest found: " + guest.getName());
        }

        return guest;
    }
}