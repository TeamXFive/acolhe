package backoffice;
public class Event {
    private int eventId;
    private String name;
    private String type;
    private String date;
    private String location;
    private String description;

    public Event(int eventId, String name, String type, String date, String location, String description) {
        this.eventId = eventId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.location = location;
        this.description = description;
    }

    public String getEventSummary() {
        return name + " - " + type + " on " + date + " at " + location;
    }

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
}
