package backoffice;
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

    public Session(int sessionId, String datetime, String status, String method, String linkWeb, String linkPhone, User user, Professional professional, Event event) {
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

    public String getSessionDetails() {
        return "Session for " + user.getFullName() + " with " + professional.getFullName() + " at " + datetime + " via " + method;
    }

    // Getters and Setters

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
