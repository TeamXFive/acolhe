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

    // A lógica de uso dos campos 'status' e 'activity' é a seguinte:
    // 'status' é usado nos métodos isAvailable(), setAvailable(), setBusy() para indicar a disponibilidade
    // de um profissional para novas sessões. No método Session.complete() e Session.cancel(), o status
    // do profissional é alterado para "AVAILABLE" após a conclusão ou cancelamento da sessão.
    // O campo 'activity' é um booleano simples que indica se o profissional está ativo no sistema.
    // Embora não haja uma lógica de "inativação" explícita no AcolheCLI para profissionais,
    // a sua presença permite futuras expansões, como filtros para listar apenas profissionais ativos.

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