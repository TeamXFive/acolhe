package backoffice.model;

public class Event {
    private int eventId;
    private String name;
    private String type;
    private String date;
    private String location;
    private String description;
    private boolean smsSent;

    public Event (
        int eventId,
        String name,
        String type,
        String date,
        String location,
        String description,
        boolean smsSent
    ) {
        this.eventId = eventId;
        this.name = name;
        this.type = type;
        this.date = date;
        this.location = location;
        this.description = description;
        this.smsSent = smsSent;
    }

    public int getEventId() {
        return eventId;
    }

    public Event setEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Event setType(String type) {
        this.type = type;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Event setDate(String date) {
        this.date = date;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Event setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isSmsSent() {
        return smsSent;
    }

    public Event setSmsSent(boolean smsSent) {
        this.smsSent = smsSent;
        return this;
    }
}