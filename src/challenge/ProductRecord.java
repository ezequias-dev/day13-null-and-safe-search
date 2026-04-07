package challenge;

public class ProductRecord {
    private final int id;
    private final String name;
    private final double price;
    private boolean available;

    public ProductRecord(int id, String name, double price, boolean available) {
        this.id = id;
        this.name = name == null ? null : name.trim();
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isValidProduct() {
        return name != null
            && name.length() >= 3
            && price > 0;
    }

    public void showProductSummary() {
        System.out.printf(
            "Id: %d | Name: %s | Price: $%.2f | Available: %b%n",
            id, name, price, available
        );
    }
}