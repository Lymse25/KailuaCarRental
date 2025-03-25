import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Trip> trips = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Create trip\n2. List trips\n3. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.println("1. Ski Trip\n2. Beach Trip");
                System.out.print("Type: ");
                int type = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Destination: ");
                String destination = scanner.nextLine();
                System.out.print("Duration (days): ");
                int duration = scanner.nextInt();
                System.out.print("Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Transport: ");
                String transport = scanner.nextLine();

                if (type == 1) {
                    System.out.print("Ski Resort: ");
                    String skiResort = scanner.nextLine();
                    System.out.print("Difficulty (1-5): ");
                    int difficulty = scanner.nextInt();
                    System.out.print("Equipment Rental (true/false): ");
                    boolean rental = scanner.nextBoolean();
                    scanner.nextLine();

                    trips.add(new SkiTrip(destination, duration, price, transport, skiResort, difficulty, rental));
                } else {
                    System.out.print("Hotel Name: ");
                    String hotel = scanner.nextLine();
                    System.out.print("All Inclusive (true/false): ");
                    boolean allInclusive = scanner.nextBoolean();
                    System.out.print("Beach Days: ");
                    int beachDays = scanner.nextInt();
                    scanner.nextLine();

                    trips.add(new BeachTrip(destination, duration, price, transport, hotel, allInclusive, beachDays));
                }
            } else if (choice == 2) {
                if (trips.isEmpty()) {
                    System.out.println("No trips available.");
                } else {
                    trips.forEach(Trip::printDetails);
                }
            } else {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}