package backoffice.model;

public class User {
    private int userId;
    private String fullName;
    private String phone;
    private String document;

    public User (
        int userId,
        String fullName,
        String phone,
        String document
    ) {
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.document = document;
    }

    // Getters and Setters
    
    public int getUserId() {
        return userId;
    }

    public User setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public User setDocument(String document) {
        this.document = document;
        return this;
    }
}