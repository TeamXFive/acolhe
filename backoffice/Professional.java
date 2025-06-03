package backoffice;
public class Professional {
    private int professionalId;
    private String fullName;
    private String phone;
    private String specialization;
    private String licenseNumber;
    private String status;
    private boolean activity;

    public Professional(int professionalId, String fullName, String phone, String licenseNumber, String status) {
        this.professionalId = professionalId;
        this.fullName = fullName;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.status = status;
    }

    public Professional(int i, String string, String string2, boolean b) {
        this.professionalId = i;
        this.fullName = string;
        this.specialization = string2;
        this.activity = b;
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
