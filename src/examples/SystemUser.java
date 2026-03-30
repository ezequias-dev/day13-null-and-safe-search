package examples;

public class SystemUser {
    private int id;
    private String fullName;
    private String email;

    public SystemUser(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public void showSummary() {
        System.out.println(
                "Id: " + id +
                " | Name: " + fullName +
                " | Email: " + email
        );
    }
}