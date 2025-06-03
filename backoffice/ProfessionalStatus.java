public enum ProfessionalStatus {
    AVAILABLE(0, "Available"),
    BUSY(1, "Busy"),
    OFFLINE(2, "Offline");

    private final int id;
    private final String description;

    ProfessionalStatus(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static ProfessionalStatus getFromId(int id) {
        for (ProfessionalStatus status : ProfessionalStatus.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("No ProfessionalStatus found for id: " + id);
    }

    public static ProfessionalStatus getFromDescription(String description) {
        for (ProfessionalStatus status : ProfessionalStatus.values()) {
            if (status.getDescription().equalsIgnoreCase(description)) {
                return status;
            }
        }
        
        throw new IllegalArgumentException("No ProfessionalStatus found for description: " + description);
    }

    public boolean matchesId (int pId) {
        for (ProfessionalStatus status : ProfessionalStatus.values()) {
            if (status.getId() == pId) {
                return true;
            }
        }

        return false;
    }
}