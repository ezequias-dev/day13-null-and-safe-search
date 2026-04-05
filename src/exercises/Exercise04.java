package exercises;

import java.util.ArrayList;

class OrderRecord {
    private final String code;
    private final double totalAmount;

    public OrderRecord(String code, double totalAmount) {
        this.code = code;
        this.totalAmount = totalAmount;
    }

    public String getCode() {
        return code;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void showOrderSummary() {
        System.out.printf(
            "Code: %s | Total amount: $%.2f%n",
            code, totalAmount
        );
    }
}

class OrderService {
    private final ArrayList<OrderRecord> orders = new ArrayList<>();

    public void addOrder(OrderRecord order) {
        if (order == null) {
            System.out.println("Order cannot be null.");
            return;
        }

        orders.add(order);
        System.out.println("Order added successfully.");
    }

    public OrderRecord findOrderByCode(String code) {
        for (OrderRecord order : orders) {
            if (code.equals(order.getCode())) {
                return order;
            }
        }
        return null;
    }

    public void removeOrderByCode(String code) {
        OrderRecord order = findOrderByCode(code);

        if (order != null) {
            orders.remove(order);
            System.out.println("Order removed successfully.");
        } else {
            System.out.println("Order not found. Nothing was removed.");
        }
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders registered.");
            return;
        }

        for (OrderRecord order : orders) {
            order.showOrderSummary();
        }
    }
}

public class Exercise04 {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.addOrder(new OrderRecord("10", 599.90));
        orderService.addOrder(new OrderRecord("11", 799.90));
        orderService.addOrder(new OrderRecord("12", 1099.90));

        System.out.println("\n---- INITIAL ORDERS ----");
        orderService.listOrders();

        System.out.println();
        orderService.removeOrderByCode("11");

        System.out.println("\n---- AFTER REMOVING CODE 11 ----");
        orderService.listOrders();

        System.out.println();
        orderService.removeOrderByCode("7");

        System.out.println("\n---- FINAL ORDERS ----");
        orderService.listOrders();

    }
}