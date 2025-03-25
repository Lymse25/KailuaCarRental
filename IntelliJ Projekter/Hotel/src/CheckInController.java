import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CheckInController {
    private HotelSystem hotelSystem;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public CheckInController(HotelSystem hotelSystem) {
        this.hotelSystem = hotelSystem;
        this.scanner = new Scanner(System.in);
    }

    public void checkIn() {
        System.out.println("\n=== CHECK-IN ===");

        System.out.print("Enter guest email: ");
        String email = scanner.nextLine();

        Guest guest = hotelSystem.findGuestByEmail(email);

        if (guest == null) {
            System.out.println("Guest not found. Please make a reservation first or check in without reservation.");
            return;
        }

        // Check if guest has reservations
        List<Reservation> guestReservations = hotelSystem.getReservationsByGuest(guest);

        if (!guestReservations.isEmpty()) {
            // Has reservations
            System.out.println("\nFound reservations for " + guest.getName() + ":");

            for (int i = 0; i < guestReservations.size(); i++) {
                Reservation reservation = guestReservations.get(i);
                System.out.printf("%d. Room %d: %s to %s%n",
                        i + 1,
                        reservation.getRoom().getRoomNumber(),
                        reservation.getFromDate().format(dateFormatter),
                        reservation.getToDate().format(dateFormatter));
            }

            System.out.print("\nSelect reservation for check-in (1-" + guestReservations.size() +
                    ") or 0 for walk-in: ");
            int reservationIndex = Integer.parseInt(scanner.nextLine());

            if (reservationIndex > 0) {
                Reservation selectedReservation = guestReservations.get(reservationIndex - 1);
                Rental rental = hotelSystem.checkIn(selectedReservation);

                System.out.println("\nCheck-in successful:");
                System.out.println("Guest: " + guest.getName());
                System.out.println("Room: " + rental.getRoom().getRoomNumber());
                System.out.println("Check-in time: " + rental.getCheckIn());
                return;
            }
        }

        // Walk-in check-in (no reservation)
        System.out.println("\nAvailable rooms for immediate check-in:");
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);

        List<Room> availableRooms = hotelSystem.getAvailableRooms(today, tomorrow);

        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available for immediate check-in.");
            return;
        }

        for (int i = 0; i < availableRooms.size(); i++) {
            Room room = availableRooms.get(i);
            System.out.printf("%d. Room %d - %d beds - %.2f kr per night%n",
                    i + 1, room.getRoomNumber(), room.getNumberOfBeds(), room.getPrice());
        }

        System.out.print("\nSelect room for check-in (1-" + availableRooms.size() + "): ");
        int roomIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Room selectedRoom = availableRooms.get(roomIndex);

        Rental rental = hotelSystem.checkIn(guest, selectedRoom);

        System.out.println("\nCheck-in successful:");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room: " + rental.getRoom().getRoomNumber());
        System.out.println("Check-in time: " + rental.getCheckIn());
    }
}