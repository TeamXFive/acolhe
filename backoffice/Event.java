package backoffice;
public class Event {
    private int eventId;
    private String name;
    private String type;
    private String date;
    private String location;
    private String description;
    private boolean smsSent; // Novo campo para o status do SMS

    public Event(int eventId, String name, String type, String date, String location, String description, boolean smsSent) {
        this.eventId = eventId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.location = location;
        this.description = description;
        this.smsSent = smsSent;
    }

    // O método getEventSummary não está sendo utilizado no AcolheCLI, pode ser removido
    /*
    public String getEventSummary() {
        return name + " - " + type + " on " + date + " at " + location;
    }
    */

    // Getters and Setters

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSmsSent() {
        return smsSent;
    }

    public void setSmsSent(boolean smsSent) {
        this.smsSent = smsSent;
    }
}