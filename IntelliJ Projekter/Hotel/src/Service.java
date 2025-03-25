public class Service {
    private String description;
    private double price;

    // Constructor
    public Service(String description, double price) {
        this.description = description;
        this.price = price;
    }

    // Getters and setters
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Service{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}