package com.lymae.kailuacarental;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class KailuaApplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarDAO carDAO = new CarDAO();
    private static final RenterDAO renterDAO = new RenterDAO();
    private static final RentalDAO rentalDAO = new RentalDAO();

    public static void main(String[] args) {
        System.out.println("Velkommen til Kailua Car Rental System!");

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getIntegerInput("Vælg en mulighed: ");

            switch (choice) {
                case 1:
                    carMenu();
                    break;
                case 2:
                    renterMenu();
                    break;
                case 3:
                    rentalMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Tak fordi du brugte Kailua Car Rental System. Farvel!");
                    DatabaseConnection.closeConnection();
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    // Hjælpemetoder til brugerinput
    private static int getIntegerInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Indtast venligst et gyldigt tal.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static LocalDateTime getDateTimeInput(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        while (true) {
            try {
                System.out.print(prompt + " (format: yyyy-MM-dd HH:mm): ");
                String input = scanner.nextLine().trim();
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ugyldig dato/tid. Brug formatet yyyy-MM-dd HH:mm (f.eks. 2025-01-15 14:30)");
            }
        }
    }

    // Hovedmenu
    private static void displayMainMenu() {
        System.out.println("\n===== HOVEDMENU =====");
        System.out.println("1. Administrer Biler");
        System.out.println("2. Administrer Lejere");
        System.out.println("3. Administrer Udlejninger");
        System.out.println("0. Afslut");
        System.out.println("=====================");
    }

    // Bilmenu og funktioner
    private static void carMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== BIL MENU =====");
            System.out.println("1. Tilføj Ny Bil");
            System.out.println("2. Vis Alle Biler");
            System.out.println("3. Søg Bil ved Registreringsnummer");
            System.out.println("4. Vis Biler efter Kategori");
            System.out.println("5. Opdater Bil");
            System.out.println("6. Slet Bil");
            System.out.println("0. Tilbage til Hovedmenu");
            System.out.println("====================");

            int choice = getIntegerInput("Vælg en mulighed: ");

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    listAllCars();
                    break;
                case 3:
                    searchCarByRegNumber();
                    break;
                case 4:
                    listCarsByCategory();
                    break;
                case 5:
                    updateCar();
                    break;
                case 6:
                    deleteCar();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private static void addCar() {
        System.out.println("\n----- Tilføj Ny Bil -----");

        // Få input fra brugeren
        String regNumber = getStringInput("Registreringsnummer: ");
        String brandModel = getStringInput("Mærke og Model: ");
        String fuelType = getStringInput("Brændstoftype: ");
        int firstRegYear = getIntegerInput("Første registreringsår: ");
        int firstRegMonth = getIntegerInput("Første registreringsmåned (1-12): ");
        int odometer = getIntegerInput("Kilometerstand: ");

        // Vis tilgængelige kategorier
        System.out.println("\nTilgængelige Kategorier:");
        List<CarCategory> categories = carDAO.getAllCategories();
        for (CarCategory category : categories) {
            System.out.println(category.getCategoryID() + ". " + category.getCategoryName());
        }

        int categoryID = getIntegerInput("Vælg kategori ID: ");
        CarCategory selectedCategory = carDAO.getCategoryById(categoryID);

        if (selectedCategory != null) {
            Car newCar = new Car(regNumber, brandModel, fuelType, firstRegYear, firstRegMonth, odometer, selectedCategory);
            carDAO.insertCar(newCar);
            System.out.println("Bil tilføjet succesfuldt!");
        } else {
            System.out.println("Ugyldig kategori valgt!");
        }
    }

    private static void listAllCars() {
        System.out.println("\n----- Alle Biler -----");
        List<Car> cars = carDAO.getAllCars();

        if (cars.isEmpty()) {
            System.out.println("Ingen biler fundet.");
        } else {
            displayCarList(cars);
        }
    }

    private static void searchCarByRegNumber() {
        System.out.println("\n----- Søg Bil ved Registreringsnummer -----");
        String regNumber = getStringInput("Indtast registreringsnummer: ");

        Car car = carDAO.getCarByRegNumber(regNumber);
        if (car != null) {
            System.out.println("\nFunden bil:");
            System.out.println(formatCarDetails(car));
        } else {
            System.out.println("Ingen bil fundet med registreringsnummer: " + regNumber);
        }
    }

    private static void listCarsByCategory() {
        System.out.println("\n----- Vis Biler efter Kategori -----");

        // Vis tilgængelige kategorier
        System.out.println("Tilgængelige Kategorier:");
        List<CarCategory> categories = carDAO.getAllCategories();
        for (CarCategory category : categories) {
            System.out.println(category.getCategoryID() + ". " + category.getCategoryName());
        }

        int categoryID = getIntegerInput("Vælg kategori ID: ");

        List<Car> cars = carDAO.getCarsByCategory(categoryID);
        if (cars.isEmpty()) {
            System.out.println("Ingen biler fundet i den valgte kategori.");
        } else {
            System.out.println("\nBiler i valgt kategori:");
            displayCarList(cars);
        }
    }

    private static void updateCar() {
        System.out.println("\n----- Opdater Bil -----");
        String regNumber = getStringInput("Indtast registreringsnummer på bilen der skal opdateres: ");

        Car existingCar = carDAO.getCarByRegNumber(regNumber);
        if (existingCar != null) {
            System.out.println("\nNuværende bil detaljer:");
            System.out.println(formatCarDetails(existingCar));

            System.out.println("\nIndtast nye oplysninger (tryk Enter for at beholde nuværende værdi):");

            String input;

            System.out.print("Mærke og Model (" + existingCar.getBrandModel() + "): ");
            input = scanner.nextLine().trim();
            String brandModel = input.isEmpty() ? existingCar.getBrandModel() : input;

            System.out.print("Brændstoftype (" + existingCar.getFuelType() + "): ");
            input = scanner.nextLine().trim();
            String fuelType = input.isEmpty() ? existingCar.getFuelType() : input;

            System.out.print("Første registreringsår (" + existingCar.getFirstRegYear() + "): ");
            input = scanner.nextLine().trim();
            int firstRegYear = input.isEmpty() ? existingCar.getFirstRegYear() : Integer.parseInt(input);

            System.out.print("Første registreringsmåned (" + existingCar.getFirstRegMonth() + "): ");
            input = scanner.nextLine().trim();
            int firstRegMonth = input.isEmpty() ? existingCar.getFirstRegMonth() : Integer.parseInt(input);

            System.out.print("Kilometerstand (" + existingCar.getOdometer() + "): ");
            input = scanner.nextLine().trim();
            int odometer = input.isEmpty() ? existingCar.getOdometer() : Integer.parseInt(input);

            // Vis tilgængelige kategorier
            System.out.println("\nTilgængelige Kategorier (nuværende: " + existingCar.getCategory().getCategoryName() + "):");
            List<CarCategory> categories = carDAO.getAllCategories();
            for (CarCategory category : categories) {
                System.out.println(category.getCategoryID() + ". " + category.getCategoryName());
            }

            System.out.print("Vælg kategori ID (tryk Enter for at beholde nuværende): ");
            input = scanner.nextLine().trim();
            int categoryID = input.isEmpty() ? existingCar.getCategory().getCategoryID() : Integer.parseInt(input);

            CarCategory selectedCategory = carDAO.getCategoryById(categoryID);
            if (selectedCategory != null) {
                Car updatedCar = new Car(regNumber, brandModel, fuelType, firstRegYear, firstRegMonth, odometer, selectedCategory);

                if (carDAO.updateCar(updatedCar)) {
                    System.out.println("Bil opdateret succesfuldt!");
                } else {
                    System.out.println("Fejl ved opdatering af bil.");
                }
            } else {
                System.out.println("Ugyldig kategori valgt!");
            }
        } else {
            System.out.println("Ingen bil fundet med registreringsnummer: " + regNumber);
        }
    }

    private static void deleteCar() {
        System.out.println("\n----- Slet Bil -----");
        String regNumber = getStringInput("Indtast registreringsnummer på bilen der skal slettes: ");

        Car car = carDAO.getCarByRegNumber(regNumber);
        if (car != null) {
            System.out.println("\nFølgende bil vil blive slettet:");
            System.out.println(formatCarDetails(car));

            String confirm = getStringInput("Er du sikker på at du vil slette denne bil? (ja/nej): ");
            if (confirm.equalsIgnoreCase("ja")) {
                if (carDAO.deleteCar(regNumber)) {
                    System.out.println("Bil slettet succesfuldt!");
                } else {
                    System.out.println("Fejl ved sletning af bil. Kontroller at der ikke er aktive udlejninger for denne bil.");
                }
            } else {
                System.out.println("Sletning annulleret.");
            }
        } else {
            System.out.println("Ingen bil fundet med registreringsnummer: " + regNumber);
        }
    }

    private static void displayCarList(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + formatCarDetails(cars.get(i)));
        }
    }

    private static String formatCarDetails(Car car) {
        return car.getRegNumber() + " | " +
                car.getBrandModel() + " | " +
                car.getFuelType() + " | " +
                "Reg: " + car.getFirstRegYear() + "-" + car.getFirstRegMonth() + " | " +
                "Km: " + car.getOdometer() + " | " +
                "Kategori: " + car.getCategory().getCategoryName();
    }

    // Lejermenu og funktioner
    private static void renterMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== LEJER MENU =====");
            System.out.println("1. Tilføj Ny Lejer");
            System.out.println("2. Vis Alle Lejere");
            System.out.println("3. Søg Lejer ved ID");
            System.out.println("4. Søg Lejer ved Navn");
            System.out.println("5. Opdater Lejer");
            System.out.println("6. Slet Lejer");
            System.out.println("0. Tilbage til Hovedmenu");
            System.out.println("=====================");

            int choice = getIntegerInput("Vælg en mulighed: ");

            switch (choice) {
                case 1:
                    addRenter();
                    break;
                case 2:
                    listAllRenters();
                    break;
                case 3:
                    searchRenterById();
                    break;
                case 4:
                    searchRentersByName();
                    break;
                case 5:
                    updateRenter();
                    break;
                case 6:
                    deleteRenter();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private static void addRenter() {
        System.out.println("\n----- Tilføj Ny Lejer -----");

        String name = getStringInput("Navn: ");
        String address = getStringInput("Adresse: ");
        String zip = getStringInput("Postnummer: ");
        String city = getStringInput("By: ");
        String mobilePhone = getStringInput("Mobiltelefon: ");
        String phone = getStringInput("Telefon (tryk Enter hvis samme som mobil): ");
        if (phone.isEmpty()) {
            phone = mobilePhone;
        }
        String email = getStringInput("Email: ");
        String driverLicenseNumber = getStringInput("Kørekortnummer: ");
        String driverSince = getStringInput("Kørekort udstedt (YYYY-MM-DD): ");

        // Renter ID sættes til 0, det vil blive auto-genereret i databasen
        Renter newRenter = new Renter(0, name, address, zip, city, mobilePhone, phone, email, driverLicenseNumber, driverSince);
        int insertedId = renterDAO.insertRenter(newRenter);

        if (insertedId > 0) {
            System.out.println("Lejer tilføjet succesfuldt med ID: " + insertedId);
        } else {
            System.out.println("Fejl ved tilføjelse af lejer.");
        }
    }

    private static void listAllRenters() {
        System.out.println("\n----- Alle Lejere -----");
        List<Renter> renters = renterDAO.getAllRenters();

        if (renters.isEmpty()) {
            System.out.println("Ingen lejere fundet.");
        } else {
            displayRenterList(renters);
        }
    }

    private static void searchRenterById() {
        System.out.println("\n----- Søg Lejer ved ID -----");
        int renterID = getIntegerInput("Indtast lejer ID: ");

        Renter renter = renterDAO.getRenterById(renterID);
        if (renter != null) {
            System.out.println("\nFunden lejer:");
            System.out.println(formatRenterDetails(renter));
        } else {
            System.out.println("Ingen lejer fundet med ID: " + renterID);
        }
    }

    private static void searchRentersByName() {
        System.out.println("\n----- Søg Lejer ved Navn -----");
        String searchTerm = getStringInput("Indtast søgeord (navn): ");

        List<Renter> renters = renterDAO.searchRentersByName(searchTerm);
        if (renters.isEmpty()) {
            System.out.println("Ingen lejere fundet der matcher søgningen.");
        } else {
            System.out.println("\nFundne lejere:");
            displayRenterList(renters);
        }
    }

    private static void updateRenter() {
        System.out.println("\n----- Opdater Lejer -----");
        int renterID = getIntegerInput("Indtast ID på lejeren der skal opdateres: ");

        Renter existingRenter = renterDAO.getRenterById(renterID);
        if (existingRenter != null) {
            System.out.println("\nNuværende lejer detaljer:");
            System.out.println(formatRenterDetails(existingRenter));

            System.out.println("\nIndtast nye oplysninger (tryk Enter for at beholde nuværende værdi):");

            String input;

            System.out.print("Navn (" + existingRenter.getName() + "): ");
            input = scanner.nextLine().trim();
            String name = input.isEmpty() ? existingRenter.getName() : input;

            System.out.print("Adresse (" + existingRenter.getAddress() + "): ");
            input = scanner.nextLine().trim();
            String address = input.isEmpty() ? existingRenter.getAddress() : input;

            System.out.print("Postnummer (" + existingRenter.getZip() + "): ");
            input = scanner.nextLine().trim();
            String zip = input.isEmpty() ? existingRenter.getZip() : input;

            System.out.print("By (" + existingRenter.getCity() + "): ");
            input = scanner.nextLine().trim();
            String city = input.isEmpty() ? existingRenter.getCity() : input;

            System.out.print("Mobiltelefon (" + existingRenter.getMobilePhone() + "): ");
            input = scanner.nextLine().trim();
            String mobilePhone = input.isEmpty() ? existingRenter.getMobilePhone() : input;

            System.out.print("Telefon (" + existingRenter.getPhone() + "): ");
            input = scanner.nextLine().trim();
            String phone = input.isEmpty() ? existingRenter.getPhone() : input;

            System.out.print("Email (" + existingRenter.getEmail() + "): ");
            input = scanner.nextLine().trim();
            String email = input.isEmpty() ? existingRenter.getEmail() : input;

            System.out.print("Kørekortnummer (" + existingRenter.getDriverLicenseNumber() + "): ");
            input = scanner.nextLine().trim();
            String driverLicenseNumber = input.isEmpty() ? existingRenter.getDriverLicenseNumber() : input;

            System.out.print("Kørekort udstedt (" + existingRenter.getDriverSince() + "): ");
            input = scanner.nextLine().trim();
            String driverSince = input.isEmpty() ? existingRenter.getDriverSince() : input;

            Renter updatedRenter = new Renter(
                    renterID, name, address, zip, city, mobilePhone, phone, email, driverLicenseNumber, driverSince
            );

            if (renterDAO.updateRenter(updatedRenter)) {
                System.out.println("Lejer opdateret succesfuldt!");
            } else {
                System.out.println("Fejl ved opdatering af lejer.");
            }
        } else {
            System.out.println("Ingen lejer fundet med ID: " + renterID);
        }
    }

    private static void deleteRenter() {
        System.out.println("\n----- Slet Lejer -----");
        int renterID = getIntegerInput("Indtast ID på lejeren der skal slettes: ");

        Renter renter = renterDAO.getRenterById(renterID);
        if (renter != null) {
            System.out.println("\nFølgende lejer vil blive slettet:");
            System.out.println(formatRenterDetails(renter));

            String confirm = getStringInput("Er du sikker på at du vil slette denne lejer? (ja/nej): ");
            if (confirm.equalsIgnoreCase("ja")) {
                if (renterDAO.deleteRenter(renterID)) {
                    System.out.println("Lejer slettet succesfuldt!");
                } else {
                    System.out.println("Fejl ved sletning af lejer. Kontroller at der ikke er aktive udlejninger for denne lejer.");
                }
            } else {
                System.out.println("Sletning annulleret.");
            }
        } else {
            System.out.println("Ingen lejer fundet med ID: " + renterID);
        }
    }

    private static void displayRenterList(List<Renter> renters) {
        for (int i = 0; i < renters.size(); i++) {
            System.out.println((i + 1) + ". " + formatRenterDetails(renters.get(i)));
        }
    }

    private static String formatRenterDetails(Renter renter) {
        return "ID: " + renter.getRenterID() + " | " +
                renter.getName() + " | " +
                renter.getAddress() + ", " +
                renter.getZip() + " " + renter.getCity() + " | " +
                "Mobil: " + renter.getMobilePhone() + " | " +
                "Email: " + renter.getEmail() + " | " +
                "Kørekort: " + renter.getDriverLicenseNumber();
    }

    // Udlejningsmenu og funktioner
    private static void rentalMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n===== UDLEJNINGS MENU =====");
            System.out.println("1. Opret Ny Udlejning");
            System.out.println("2. Vis Alle Udlejninger");
            System.out.println("3. Søg Udlejning ved ID");
            System.out.println("4. Vis Udlejninger efter Lejer");
            System.out.println("5. Vis Udlejninger efter Bil");
            System.out.println("6. Vis Aktive Udlejninger");
            System.out.println("7. Opdater Udlejning");
            System.out.println("8. Slet Udlejning");
            System.out.println("0. Tilbage til Hovedmenu");
            System.out.println("=========================");

            int choice = getIntegerInput("Vælg en mulighed: ");

            switch (choice) {
                case 1:
                    addRental();
                    break;
                case 2:
                    listAllRentals();
                    break;
                case 3:
                    searchRentalById();
                    break;
                case 4:
                    listRentalsByRenter();
                    break;
                case 5:
                    listRentalsByCar();
                    break;
                case 6:
                    listActiveRentals();
                    break;
                case 7:
                    updateRental();
                    break;
                case 8:
                    deleteRental();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
    }

    private static void addRental() {
        System.out.println("\n----- Opret Ny Udlejning -----");

        // Vælg lejer
        System.out.println("\nVælg Lejer:");
        System.out.println("1. Søg efter eksisterende lejer");
        System.out.println("2. Opret ny lejer");

        int choice = getIntegerInput("Vælg en mulighed: ");
        Renter selectedRenter = null;

        if (choice == 1) {
            String searchTerm = getStringInput("Søg efter lejer (navn): ");
            List<Renter> renters = renterDAO.searchRentersByName(searchTerm);

            if (renters.isEmpty()) {
                System.out.println("Ingen lejere fundet. Du skal oprette en ny lejer.");
                return;
            } else {
                System.out.println("\nFundne lejere:");
                displayRenterList(renters);
                int renterIndex = getIntegerInput("Vælg lejer (nummer): ") - 1;

                if (renterIndex >= 0 && renterIndex < renters.size()) {
                    selectedRenter = renters.get(renterIndex);
                } else {
                    System.out.println("Ugyldigt valg.");
                    return;
                }
            }
        } else if (choice == 2) {
            System.out.println("\nIndtast oplysninger om den nye lejer:");
            String name = getStringInput("Navn: ");
            String address = getStringInput("Adresse: ");
            String zip = getStringInput("Postnummer: ");
            String city = getStringInput("By: ");
            String mobilePhone = getStringInput("Mobiltelefon: ");
            String phone = getStringInput("Telefon (tryk Enter hvis samme som mobil): ");
            if (phone.isEmpty()) {
                phone = mobilePhone;
            }
            String email = getStringInput("Email: ");
            String driverLicenseNumber = getStringInput("Kørekortnummer: ");
            String driverSince = getStringInput("Kørekort udstedt (YYYY-MM-DD): ");

            Renter newRenter = new Renter(0, name, address, zip, city, mobilePhone, phone, email, driverLicenseNumber, driverSince);
            int insertedId = renterDAO.insertRenter(newRenter);

            if (insertedId > 0) {
                selectedRenter = renterDAO.getRenterById(insertedId);
            } else {
                System.out.println("Fejl ved oprettelse af lejer.");
                return;
            }
        } else {
            System.out.println("Ugyldigt valg.");
            return;
        }

        // Vælg bil
        System.out.println("\nVælg Bil:");
        String regNumber = getStringInput("Indtast registreringsnummer: ");
        Car selectedCar = carDAO.getCarByRegNumber(regNumber);

        if (selectedCar == null) {
            System.out.println("Ingen bil fundet med registreringsnummer: " + regNumber);
            return;
        }

        // Udlejningsdetaljer
        LocalDateTime fromDateTime = getDateTimeInput("Fra dato/tid");
        LocalDateTime toDateTime = getDateTimeInput("Til dato/tid");

        // Validér datoer
        if (toDateTime.isBefore(fromDateTime)) {
            System.out.println("Fejl: Slutdato kan ikke være før startdato.");
            return;
        }

        int maxKm = getIntegerInput("Maksimalt antal kilometer: ");
        int startKm = selectedCar.getOdometer();

        // Bekræft oplysninger
        System.out.println("\nBekræft udlejningsoplysninger:");
        System.out.println("Lejer: " + selectedRenter.getName());
        System.out.println("Bil: " + selectedCar.getBrandModel() + " (" + selectedCar.getRegNumber() + ")");
        System.out.println("Fra: " + fromDateTime);
        System.out.println("Til: " + toDateTime);
        System.out.println("Maksimalt km: " + maxKm);
        System.out.println("Start km: " + startKm);

        String confirm = getStringInput("\nEr disse oplysninger korrekte? (ja/nej): ");
        if (confirm.equalsIgnoreCase("ja")) {
            Rental newRental = new Rental(0, selectedRenter, selectedCar, fromDateTime, toDateTime, maxKm, startKm);
            int rentalId = rentalDAO.insertRental(newRental);

            if (rentalId > 0) {
                System.out.println("Udlejning oprettet succesfuldt med ID: " + rentalId);
            } else {
                System.out.println("Fejl ved oprettelse af udlejning.");
            }
        } else {
            System.out.println("Udlejning annulleret.");
        }
    }

    private static void listAllRentals() {
        System.out.println("\n----- Alle Udlejninger -----");
        List<Rental> rentals = rentalDAO.getAllRentals();

        if (rentals.isEmpty()) {
            System.out.println("Ingen udlejninger fundet.");
        } else {
            displayRentalList(rentals);
        }
    }

    private static void searchRentalById() {
        System.out.println("\n----- Søg Udlejning ved ID -----");
        int rentalId = getIntegerInput("Indtast udlejnings ID: ");

        Rental rental = rentalDAO.getRentalById(rentalId);
        if (rental != null) {
            System.out.println("\nFunden udlejning:");
            System.out.println(formatRentalDetails(rental));
        } else {
            System.out.println("Ingen udlejning fundet med ID: " + rentalId);
        }
    }

    private static void listRentalsByRenter() {
        System.out.println("\n----- Vis Udlejninger efter Lejer -----");

        // Søg efter lejer
        String searchTerm = getStringInput("Søg efter lejer (navn): ");
        List<Renter> renters = renterDAO.searchRentersByName(searchTerm);

        if (renters.isEmpty()) {
            System.out.println("Ingen lejere fundet.");
            return;
        }

        System.out.println("\nFundne lejere:");
        displayRenterList(renters);
        int renterIndex = getIntegerInput("Vælg lejer (nummer): ") - 1;

        if (renterIndex >= 0 && renterIndex < renters.size()) {
            Renter selectedRenter = renters.get(renterIndex);

            List<Rental> rentals = rentalDAO.getRentalsByRenterId(selectedRenter.getRenterID());
            if (rentals.isEmpty()) {
                System.out.println("Ingen udlejninger fundet for den valgte lejer.");
            } else {
                System.out.println("\nUdlejninger for " + selectedRenter.getName() + ":");
                displayRentalList(rentals);
            }
        } else {
            System.out.println("Ugyldigt valg.");
        }
    }

    private static void listRentalsByCar() {
        System.out.println("\n----- Vis Udlejninger efter Bil -----");
        String regNumber = getStringInput("Indtast bilens registreringsnummer: ");

        Car car = carDAO.getCarByRegNumber(regNumber);
        if (car == null) {
            System.out.println("Ingen bil fundet med registreringsnummer: " + regNumber);
            return;
        }

        List<Rental> rentals = rentalDAO.getRentalsByCarRegNumber(regNumber);
        if (rentals.isEmpty()) {
            System.out.println("Ingen udlejninger fundet for bilen: " + car.getBrandModel() + " (" + regNumber + ")");
        } else {
            System.out.println("\nUdlejninger for " + car.getBrandModel() + " (" + regNumber + "):");
            displayRentalList(rentals);
        }
    }

    private static void listActiveRentals() {
        System.out.println("\n----- Aktive Udlejninger -----");
        List<Rental> rentals = rentalDAO.getActiveRentals();

        if (rentals.isEmpty()) {
            System.out.println("Ingen aktive udlejninger fundet.");
        } else {
            System.out.println("\nAktive udlejninger:");
            displayRentalList(rentals);
        }
    }

    private static void updateRental() {
        System.out.println("\n----- Opdater Udlejning -----");
        int rentalId = getIntegerInput("Indtast ID på udlejningen der skal opdateres: ");

        Rental existingRental = rentalDAO.getRentalById(rentalId);
        if (existingRental != null) {
            System.out.println("\nNuværende udlejningsdetaljer:");
            System.out.println(formatRentalDetails(existingRental));

            System.out.println("\nHvad vil du opdatere?");
            System.out.println("1. Lejer");
            System.out.println("2. Bil");
            System.out.println("3. Datoer og kilometerbegrænsning");
            System.out.println("0. Annuller");

            int choice = getIntegerInput("Vælg en mulighed: ");

            Renter updatedRenter = existingRental.getRenter();
            Car updatedCar = existingRental.getCar();
            LocalDateTime updatedFromDateTime = existingRental.getFromDateTime();
            LocalDateTime updatedToDateTime = existingRental.getToDateTime();
            int updatedMaxKm = existingRental.getMaxKm();
            int updatedStartKm = existingRental.getStartKm();

            switch (choice) {
                case 1:
                    System.out.println("\nVælg ny lejer:");
                    String searchTerm = getStringInput("Søg efter lejer (navn): ");
                    List<Renter> renters = renterDAO.searchRentersByName(searchTerm);

                    if (!renters.isEmpty()) {
                        System.out.println("\nFundne lejere:");
                        displayRenterList(renters);
                        int renterIndex = getIntegerInput("Vælg lejer (nummer): ") - 1;

                        if (renterIndex >= 0 && renterIndex < renters.size()) {
                            updatedRenter = renters.get(renterIndex);
                        } else {
                            System.out.println("Ugyldigt valg. Forbliver ved nuværende lejer.");
                        }
                    } else {
                        System.out.println("Ingen lejere fundet. Forbliver ved nuværende lejer.");
                    }
                    break;

                case 2:
                    System.out.println("\nVælg ny bil:");
                    String regNumber = getStringInput("Indtast registreringsnummer: ");
                    Car car = carDAO.getCarByRegNumber(regNumber);

                    if (car != null) {
                        updatedCar = car;
                        updatedStartKm = car.getOdometer(); // Opdaterer startkilometer til den nye bils kilometerstand
                    } else {
                        System.out.println("Ingen bil fundet. Forbliver ved nuværende bil.");
                    }
                    break;

                case 3:
                    System.out.println("\nOpdater datoer og kilometerbegrænsning:");
                    System.out.println("Nuværende fra dato/tid: " + updatedFromDateTime);
                    String updateFrom = getStringInput("Vil du opdatere fra dato/tid? (ja/nej): ");
                    if (updateFrom.equalsIgnoreCase("ja")) {
                        updatedFromDateTime = getDateTimeInput("Ny fra dato/tid");
                    }

                    System.out.println("Nuværende til dato/tid: " + updatedToDateTime);
                    String updateTo = getStringInput("Vil du opdatere til dato/tid? (ja/nej): ");
                    if (updateTo.equalsIgnoreCase("ja")) {
                        updatedToDateTime = getDateTimeInput("Ny til dato/tid");
                    }

                    // Validér datoer
                    if (updatedToDateTime.isBefore(updatedFromDateTime)) {
                        System.out.println("Fejl: Slutdato kan ikke være før startdato.");
                        return;
                    }

                    System.out.println("Nuværende maksimalt antal kilometer: " + updatedMaxKm);
                    String updateMaxKm = getStringInput("Vil du opdatere maksimalt antal kilometer? (ja/nej): ");
                    if (updateMaxKm.equalsIgnoreCase("ja")) {
                        updatedMaxKm = getIntegerInput("Nyt maksimalt antal kilometer: ");
                    }

                    System.out.println("Nuværende start kilometerstand: " + updatedStartKm);
                    String updateStartKm = getStringInput("Vil du opdatere start kilometerstand? (ja/nej): ");
                    if (updateStartKm.equalsIgnoreCase("ja")) {
                        updatedStartKm = getIntegerInput("Ny start kilometerstand: ");
                    }
                    break;

                case 0:
                    System.out.println("Opdatering annulleret.");
                    return;

                default:
                    System.out.println("Ugyldigt valg. Opdatering annulleret.");
                    return;
            }

            // Bekræft opdateringer
            System.out.println("\nBekræft opdaterede udlejningsoplysninger:");
            System.out.println("Lejer: " + updatedRenter.getName());
            System.out.println("Bil: " + updatedCar.getBrandModel() + " (" + updatedCar.getRegNumber() + ")");
            System.out.println("Fra: " + updatedFromDateTime);
            System.out.println("Til: " + updatedToDateTime);
            System.out.println("Maksimalt km: " + updatedMaxKm);
            System.out.println("Start km: " + updatedStartKm);

            String confirm = getStringInput("\nEr disse oplysninger korrekte? (ja/nej): ");
            if (confirm.equalsIgnoreCase("ja")) {
                Rental updatedRental = new Rental(
                        rentalId, updatedRenter, updatedCar, updatedFromDateTime,
                        updatedToDateTime, updatedMaxKm, updatedStartKm
                );

                if (rentalDAO.updateRental(updatedRental)) {
                    System.out.println("Udlejning opdateret succesfuldt!");
                } else {
                    System.out.println("Fejl ved opdatering af udlejning.");
                }
            } else {
                System.out.println("Opdatering annulleret.");
            }
        } else {
            System.out.println("Ingen udlejning fundet med ID: " + rentalId);
        }
    }

    private static void deleteRental() {
        System.out.println("\n----- Slet Udlejning -----");
        int rentalId = getIntegerInput("Indtast ID på udlejningen der skal slettes: ");

        Rental rental = rentalDAO.getRentalById(rentalId);
        if (rental != null) {
            System.out.println("\nFølgende udlejning vil blive slettet:");
            System.out.println(formatRentalDetails(rental));

            String confirm = getStringInput("Er du sikker på at du vil slette denne udlejning? (ja/nej): ");
            if (confirm.equalsIgnoreCase("ja")) {
                if (rentalDAO.deleteRental(rentalId)) {
                    System.out.println("Udlejning slettet succesfuldt!");
                } else {
                    System.out.println("Fejl ved sletning af udlejning.");
                }
            } else {
                System.out.println("Sletning annulleret.");
            }
        } else {
            System.out.println("Ingen udlejning fundet med ID: " + rentalId);
        }
    }

    private static void displayRentalList(List<Rental> rentals) {
        for (int i = 0; i < rentals.size(); i++) {
            System.out.println((i + 1) + ". " + formatRentalDetails(rentals.get(i)));
        }
    }

    private static String formatRentalDetails(Rental rental) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return "ID: " + rental.getRentalID() + " | " +
                "Lejer: " + rental.getRenter().getName() + " | " +
                "Bil: " + rental.getCar().getBrandModel() + " (" + rental.getCar().getRegNumber() + ") | " +
                "Fra: " + rental.getFromDateTime().format(formatter) + " | " +
                "Til: " + rental.getToDateTime().format(formatter) + " | " +
                "Max Km: " + rental.getMaxKm() + " | " +
                "Start Km: " + rental.getStartKm();
    }
}