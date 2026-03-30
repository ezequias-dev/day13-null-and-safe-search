package exercises;

import java.util.ArrayList;

class ProductRecord {
    private int id;
    private String name;
    private double price;

    public ProductRecord(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void showProduct() {
        System.out.printf("Id: %d | Name: %s | Price: $%.2f%n", getId(), getName(), getPrice());
    }
}

class ProductService {
    private final ArrayList<ProductRecord> products = new ArrayList<>();

    public void addProduct(ProductRecord product) {
        products.add(product);
    }

    public ProductRecord findProductById(int id) {
        for (ProductRecord product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}

public class Exercise01 {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        productService.addProduct(new ProductRecord(1, "MacBook Neo", 599.00));
        productService.addProduct(new ProductRecord(2, "MacBook Air", 1099.00));
        productService.addProduct(new ProductRecord(3, "MacBook Pro", 1699.00));

        int targetId = 3;

        ProductRecord product = productService.findProductById(targetId);

        if (product != null) {
            product.showProduct();
        } else {
            System.out.println("Product not found");
        }
    }
}