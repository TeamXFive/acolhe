package backoffice.controller;

import backoffice.model.Event;
import backoffice.service.EventService;

import java.util.List;

public class EventController {
    
    EventService eventService = new EventService();
    
    public void listarEventos(List<Event> events) {
        eventService.listarEventos(events);
    }
}
