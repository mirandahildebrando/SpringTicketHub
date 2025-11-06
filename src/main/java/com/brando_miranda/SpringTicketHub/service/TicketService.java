package com.brando_miranda.SpringTicketHub.service;


import com.brando_miranda.SpringTicketHub.entity.Event;
import com.brando_miranda.SpringTicketHub.entity.Status;
import com.brando_miranda.SpringTicketHub.entity.Ticket;
import com.brando_miranda.SpringTicketHub.repository.TicketRepository;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService (TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }



    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public Ticket update(Long id, Ticket ticket) {
        if(!ticketRepository.existsById(id)) {
            throw new RuntimeException("Ticket not found");
        }
        return ticketRepository.save(ticket);
    }

    public void delete(Long id) {
        if(!ticketRepository.existsById(id)) {
            throw new RuntimeException("Ticket not found");
        }
        ticketRepository.deleteById(id);
    }



    }