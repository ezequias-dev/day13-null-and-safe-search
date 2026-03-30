package examples;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new SystemUser(1, "Ezequias Souza", "ezequias@email.com"));
        userService.addUser(new SystemUser(2, "Maria Silva", "maria@email.com"));

        SystemUser foundUser = userService.findByEmail("joao@email.com");

        if (foundUser != null) {
            System.out.println("User found:");
            foundUser.showSummary();
        } else {
            System.out.println("User not found.");
        }
    }
}