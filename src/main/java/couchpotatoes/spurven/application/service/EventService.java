package couchpotatoes.spurven.application.service;


import couchpotatoes.spurven.application.entity.Event;
import couchpotatoes.spurven.application.repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public List<Event> getAllContacts() {
        return eventRepository.findAll();
    }
    public Event getEvent(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Event not found"));
    }
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event editEvent(Event body, int id) {
        Event event = getEvent(id);
        event.setTitle(body.getTitle());
        event.setDescription(body.getDescription());
        event.setStart(body.getStart());
        event.setEnd(body.getEnd());
        return eventRepository.save(event);
    }
    public String deleteEvent(int id) {
        Event event = getEvent(id);
        eventRepository.delete(event);
        return "Event got deleted";
    }
}
