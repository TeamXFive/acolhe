package backoffice;
public class Professional {
    private int professionalId;
    private String fullName;
    private String phone;
    private String specialization;
    private String licenseNumber;
    private String status; // "AVAILABLE", "BUSY"
    private boolean activity; // true para ativo, false para inativo

    // Construtor principal
    public Professional(int professionalId, String fullName, String phone, String specialization, String licenseNumber, String status, boolean activity) {
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

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean getActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }
}