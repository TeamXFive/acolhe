package backoffice.model;

public class Session {
    private int sessionId;
    private String datetime;
    private String status;  // SCHEDULED, COMPLETED, CANCELLED
    private String method;  // WEB, PHONE
    private String linkWeb;
    private String linkPhone;
    private User user;
    private Professional professional;
    private Event event;

    public Session (
        int sessionId,
        String datetime,
        String status,
        String method,
        String linkWeb,
        String linkPhone,
        User user,
        Professional professional,
        Event event
    ) {
        this.sessionId = sessionId;
        this.datetime = datetime;
        this.status = status;
        this.method = method;
        this.linkWeb = linkWeb;
        this.linkPhone = linkPhone;
        this.user = user;
        this.professional = professional;
        this.event = event;
    }

    public void confirm() {
        this.status = "SCHEDULED";
    }

    public void complete() {
        this.status = "COMPLETED";
        professional.setAvailable();
    }

    public void cancel() {
        this.status = "CANCELLED";
        professional.setAvailable();
    }

    // Getters and Setters
    
    public int getSessionId() {
        return sessionId;
    }

    public Session setSessionId(int sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    public String getDatetime() {
        return datetime;
    }

    public Session setDatetime(String datetime) {
        this.datetime = datetime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Session setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public Session setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public Session setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
        return this;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public Session setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Session setUser(User user) {
        this.user = user;
        return this;
    }

    public Professional getProfessional() {
        return professional;
    }

    public Session setProfessional(Professional professional) {
        this.professional = professional;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public Session setEvent(Event event) {
        this.event = event;
        return this;
    }
}