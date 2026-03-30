package review;

import java.util.ArrayList;

class CustomerRecord {
    private String fullName;
    private String email;

    public CustomerRecord(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}

class CustomerService {
    private final ArrayList<CustomerRecord> customers = new ArrayList<>();

    public void addCustomer(CustomerRecord customer) {
        customers.add(customer);
    }

    public void listCustomers() {
        for (CustomerRecord customer : customers) {
            System.out.println("Name: " + customer.getFullName() + " | Email: " + customer.getEmail());
        }
    }

    public CustomerRecord findByEmail(String email) {
        for (CustomerRecord customer : customers) {
            if (customer.getEmail().trim().equals(email)) {
                return customer;
            }
        }

        return null;
    }
}

public class Day12QuickReview {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        customerService.addCustomer(new CustomerRecord("Ezequias Souza", "ezequias@email.com"));
        customerService.addCustomer(new CustomerRecord("Marli Santos", "marli@email.com"));
        customerService.addCustomer(new CustomerRecord("Adealdo Roberto", "adealdo@email.com"));

        String targetEmail = "marli@email.com";
        CustomerRecord findEmail = customerService.findByEmail(targetEmail);

        if (findEmail != null) {
            System.out.println("Name: " + findEmail.getFullName() + " | Email: " + findEmail.getEmail());
        } else {
            System.out.println("Email not found.");
        }
    }
}