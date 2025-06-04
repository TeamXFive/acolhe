package backoffice;

public class User {
    private int userId;
    private String fullName;
    private String phone;
    private String document;
    // O campo 'status' não está sendo utilizado na classe User.java, pode ser removido.
    // private String status;

    public User(int userId, String fullName, String phone, String document, String status) {
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.document = document;
        // this.status = status; // Removido
    }

    // O método getFirstName não está sendo utilizado no AcolheCLI, pode ser removido.
    /*
    public String getFirstName() {
        if (fullName == null || fullName.isEmpty()) return "";
        return fullName.split(" ")[0];
    }
    */

    // Getters and Setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}