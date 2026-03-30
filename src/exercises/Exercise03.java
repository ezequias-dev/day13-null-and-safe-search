package exercises;

import java.util.ArrayList;

class UserRecord {
    private int id;
    private String fullName;
    private boolean active;

    public UserRecord(int id, String fullName, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void showSummary() {
        System.out.println("Id: " + getId() + " | Name: " + getFullName() + " | Active: " + isActive());
    }
}

class UserService {
    private final ArrayList<UserRecord> users = new ArrayList<>();

    public void addUser(UserRecord user) {
        users.add(user);
    }

    public UserRecord findUserById(int id) {
        for (UserRecord user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public UserRecord changeStatusById(int id, boolean newActive) {
       UserRecord user = findUserById(id);

       if (user != null) {
           user.setActive(newActive);
       }

       return user;
    }
}

public class Exercise03 {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new UserRecord(1, "Ezequias Souza", true));
        userService.addUser(new UserRecord(2, "Paulo Silva", true));
        userService.addUser(new UserRecord(3, "Silas Gomes", false));

        UserRecord updateUser = userService.changeStatusById(3, true);
        UserRecord missingUser = userService.changeStatusById(4, true);

        if (updateUser != null) {
            updateUser.showSummary();
        } else {
            System.out.println("Id not found");
        }

        if (missingUser != null) {
            missingUser.showSummary();
        } else {
            System.out.println("Id not found");
        }
    }
}