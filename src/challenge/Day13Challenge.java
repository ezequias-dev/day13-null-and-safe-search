package challenge;

import java.util.Scanner;

public class Day13Challenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        int option;

        do {
            System.out.println();
            System.out.println("|---------- OPTIONS MENU ----------|");
            System.out.println("| Option - 1 Register product      |");
            System.out.println("| Option - 2 List products         |");
            System.out.println("| Option - 3 Search product by id  |");
            System.out.println("| Option - 4 Exit                  |");
            System.out.println("|----------------------------------|");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.println();
                System.out.println("---- REGISTER PRODUCT ----");

                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter available (true/false): ");
                boolean available = scanner.nextBoolean();
                scanner.nextLine();

                boolean isProductAdded = productService.addProduct(new ProductRecord(id, name, price, available));

                if (isProductAdded) {
                    System.out.println("Product added successfully");
                } else {
                    System.out.println("Invalid product");
                }

            } else if (option == 2) {
                System.out.println();
                System.out.println("---- LIST PRODUCTS ----");
                productService.listProducts();

            } else if (option == 3) {
                System.out.println();
                System.out.println("---- FIND BY ID ----");

                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                ProductRecord foundProduct = productService.findById(id);

                if (foundProduct != null) {
                    foundProduct.showProductSummary();
                } else {
                    System.out.println("Product not found");
                }

            } else if (option == 4) {
                System.out.println("End program.");
                scanner.close();
                return;

            } else {
                System.out.println("Invalid option.");
            }
        } while (true);
    }
}