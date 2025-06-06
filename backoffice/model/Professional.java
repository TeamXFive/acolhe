package backoffice.model;

public class Professional {
    
    private int professionalId;
    private String fullName;
    private String phone;
    private String specialization;
    private String licenseNumber;
    private String status;
    private boolean activity;
    
    public Professional (
        int professionalId,
        String fullName,
        String phone,
        String specialization,
        String licenseNumber,
        String status,
        boolean activity
    ) {
        this.professionalId = professionalId;
        this.fullName = fullName;
        this.phone = phone;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.status = status;
        this.activity = activity;
    }

    public boolean isAvailable() {
        return status.equalsIgnoreCase("AVAILABLE");
    }

    public void setAvailable() {
        this.status = "AVAILABLE";
    }

    public void setBusy() {
        this.status = "BUSY";
    }

    // Getters and Setters

    public int getProfessionalId() {
        return professionalId;
    }

    public Professional setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Professional setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Professional setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Professional setSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Professional setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Professional setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isActivity() {
        return activity;
    }

    public Professional setActivity(boolean activity) {
        this.activity = activity;
        return this;
    }
}