package examples;

import java.util.ArrayList;

public class UserService {
    private ArrayList<SystemUser> users = new ArrayList<>();

    public void addUser(SystemUser user) {
        users.add(user);
    }

    public SystemUser findByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                return users.get(i);
            }
        }

        return null;
    }

    public void listUsers() {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).showSummary();
        }
    }
}