import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CheckOutController {
    private HotelSystem hotelSystem;
    private Scanner scanner;

    public CheckOutController(HotelSystem hotelSystem) {
        this.hotelSystem = hotelSystem;
        this.scanner = new Scanner(System.in);
    }

    public void checkOut() {
        System.out.println("\n=== CHECK-OUT ===");

        System.out.print("Enter guest email: ");
        String email = scanner.nextLine();

        Guest guest = hotelSystem.findGuestByEmail(email);

        if (guest == null) {
            System.out.println("Guest not found.");
            return;
        }

        // Find active rentals for this guest
        List<Rental> activeRentals = hotelSystem.getRentals().stream()
                .filter(r -> r.getGuest().equals(guest) && r.getCheckOut() == null)
                .collect(Collectors.toList());

        if (activeRentals.isEmpty()) {
            System.out.println("No active rentals found for " + guest.getName());
            return;
        }

        System.out.println("\nActive rentals for " + guest.getName() + ":");

        for (int i = 0; i < activeRentals.size(); i++) {
            Rental rental = activeRentals.get(i);
            System.out.printf("%d. Room %d - Checked in: %s%n",
                    i + 1, rental.getRoom().getRoomNumber(), rental.getCheckIn());
        }

        System.out.print("\nSelect rental for check-out (1-" + activeRentals.size() + "): ");
        int rentalIndex = Integer.parseInt(scanner.nextLine()) - 1;
        Rental selectedRental = activeRentals.get(rentalIndex);

        // Add additional purchases
        addPurchases(selectedRental);

        // Process check-out
        double totalAmount = hotelSystem.checkOut(selectedRental);

        // Display invoice
        System.out.println("\n=== INVOICE ===");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room: " + selectedRental.getRoom().getRoomNumber());
        System.out.println("Check-in: " + selectedRental.getCheckIn());
        System.out.println("Check-out: " + selectedRental.getCheckOut());

        System.out.println("\nItems:");
        System.out.printf("Room charges: %.2f kr%n",
                selectedRental.getRoom().getPrice() *
                        (selectedRental.getCheckIn().toLocalDate()
                                .until(selectedRental.getCheckOut().toLocalDate()).getDays() + 1));

        for (Purchase purchase : selectedRental.getPurchases()) {
            System.out.printf("%s: %d x %.2f = %.2f kr%n",
                    purchase.getService().getDescription(),
                    purchase.getQuantity(),
                    purchase.getService().getPrice(),
                    purchase.calculateTotal());
        }

        System.out.printf("\nTotal amount: %.2f kr%n", totalAmount);

        // Process payment
        System.out.print("\nEnter amount paid: ");
        double amountPaid = Double.parseDouble(scanner.nextLine());

        double change = amountPaid - totalAmount;
        System.out.printf("Change: %.2f kr%n", change);

        System.out.println("\nThank you for staying with us!");
    }

    private void addPurchases(Rental rental) {
        boolean addingPurchases = true;

        System.out.println("\n=== ADD PURCHASES ===");

        while (addingPurchases) {
            System.out.println("\nAvailable services:");
            List<Service> services = hotelSystem.get