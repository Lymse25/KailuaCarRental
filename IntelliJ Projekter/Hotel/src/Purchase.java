import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private int quantity;
    private Service service;
    private Rental rental;
    private List<Service> services;

    // Constructor
    public Purchase(int quantity, Service service, Rental rental) {
        this.quantity = quantity;
        this.service = service;
        this.rental = rental;
        this.services = new ArrayList<>();
    }

    // Methods
    public void addService(Service service) {
        services.add(service);
    }

    public double calculateTotal() {
        return quantity * service.getPrice();
    }

    // Getters and setters
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }

    public Rental getRental() { return rental; }
    public void setRental(Rental rental) { this.rental = rental; }

    public List<Service> getServices() { return services; }
}