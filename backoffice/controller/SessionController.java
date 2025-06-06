package backoffice.controller;

import backoffice.model.Session;
import backoffice.service.SessionService;

import java.util.List;

public class SessionController {
    
    SessionService sessionService = new SessionService();
    
    public void listarSessoes(List<Session> sessions) {
        sessionService.listarSessoes(sessions);
    }
}
