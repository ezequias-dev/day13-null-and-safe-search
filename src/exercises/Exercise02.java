package exercises;

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

    public void showSummary() {
        System.out.println("Name: " + getFullName() + " | Email: " + getEmail());
    }
}

class CustomerService {
    private final ArrayList<CustomerRecord> customers = new ArrayList<>();

    public void addCustomer(CustomerRecord customer) {
        customers.add(customer);
    }

    public CustomerRecord findCustomerByEmail(String email) {
        for (CustomerRecord customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }

        return null;
    }
}

public class Exercise02 {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        customerService.addCustomer(new CustomerRecord("Ezequias Souza", "ezequias@email.com"));
        customerService.addCustomer(new CustomerRecord("Marli Santos", "marli@email.com"));
        customerService.addCustomer(new CustomerRecord("Luiz Roberto", "luiz@email.com"));
        customerService.addCustomer(new CustomerRecord("Jair Bolsonaro", "bolsonaro@email.com"));

        String existingEmail = "bolsonaro@email.com";
        String missingEmail = "maria@email.com";

        CustomerRecord foundCustomer = customerService.findCustomerByEmail(existingEmail);
        CustomerRecord missingCustomer = customerService.findCustomerByEmail(missingEmail);

        if (foundCustomer != null) {
            foundCustomer.showSummary();
        } else {
            System.out.println("Email not found");
        }

        if (missingCustomer != null) {
            missingCustomer.showSummary();
        } else {
            System.out.println("Email not found");
        }
    }
}