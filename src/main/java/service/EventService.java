package service;

import com.brando_miranda.SpringTicketHub.entity.Event;
import com.brando_miranda.SpringTicketHub.entity.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EventRepository;
import repository.TicketRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;

    public EventService(EventRepository eventRepository, TicketRepository ticketRepository) {
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public Event createEvent(Event event) {
        Event savedEvent = eventRepository.save(event);


        for (int i = 0; i < event.getAvaliableQuantity(); i++) {
            UUID codigo = UUID.randomUUID();

            Ticket ticket = new Ticket(codigo, null, savedEvent);

            ticketRepository.save(ticket);
        }
        return savedEvent;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event update(Long id, Event event) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found");
        }
        event.setId(id);
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found");
        }
        eventRepository.deleteById(id);
    }


}
