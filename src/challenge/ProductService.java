package challenge;

import java.util.ArrayList;

public class ProductService {
    private final ArrayList<ProductRecord> products = new ArrayList<>();

    public boolean addProduct(ProductRecord product) {
        if (product == null || !product.isValidProduct()) {
            return false;
        }

        products.add(product);
        return true;
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No product registered.");
            return;
        }

        for (ProductRecord product : products) {
            product.showProductSummary();
        }
    }

    public ProductRecord findById(int id) {
        for (ProductRecord product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public boolean updateAvailabilityById(int id, boolean available) {
        ProductRecord found = findById(id);

        if (found != null) {
            found.setAvailable(available);
            return true;
        }
        return false;
    }

    public boolean removeById(int id) {
        ProductRecord productToRemove = findById(id);

        if (productToRemove != null) {
            return products.remove(productToRemove);
        }

        return false;
    }
}
