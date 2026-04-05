package exercises;

import java.util.ArrayList;

class EmployeeRecord {
    private final int id;
    private final String name;
    private final String department;

    public EmployeeRecord(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void showEmployeeSummary() {
        System.out.printf("Id: %d | Name: %s | Department: %s%n", id, name, department);
    }
}

class EmployeeService {
    private final ArrayList<EmployeeRecord> employees = new ArrayList<>();

    public void addEmployee(EmployeeRecord employee) {
        if (employee == null) {
            System.out.println("Employee cannot be null.");
            return;
        }

        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public EmployeeRecord findEmployeeById(int id) {
        if (id < 1) {
            return null;
        }

        for (EmployeeRecord employee : employees) {
            if (id == employee.getId()) {
                return employee;
            }
        }

        return null;
    }
}

public class Exercise05 {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        employeeService.addEmployee(new EmployeeRecord(1, "Marli Santos", "Marketing"));
        employeeService.addEmployee(new EmployeeRecord(2, "Ezequias Souza", "Backend"));
        employeeService.addEmployee(new EmployeeRecord(3, "Pedro Silva", "Frontend"));
        employeeService.addEmployee(new EmployeeRecord(4, "Gustavo Alberto", "Fullstack"));

        System.out.println("\n---- FINDING ID 3 ----");
        EmployeeRecord employee1 = employeeService.findEmployeeById(3);
        if (employee1 != null) {
            employee1.showEmployeeSummary();
            System.out.println("Employee found.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\n---- FINDING ID 6 ----");
        EmployeeRecord employee2 = employeeService.findEmployeeById(6);
        if (employee2 != null) {
            employee2.showEmployeeSummary();
            System.out.println("Employee found.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}