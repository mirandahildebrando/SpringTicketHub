package com.brando_miranda.SpringTicketHub.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private UUID uniqueCode;

    private String buyerName;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Ticket(UUID uniqueCode, String buyerName, Status status, Event event) {
        this.uniqueCode = uniqueCode;
        this.buyerName = buyerName;
        this.status = status;
        this.event = event;
    }


    public Ticket(UUID codigo, Object o, Event savedEvent) {
    }


    public Long getId() {
        return id;
    }


    public UUID getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(UUID uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public void sell(String buyerName) {
        if (this.status == Status.avaliable) {
            this.status = Status.sold;
            this.buyerName = buyerName;
        } else {
            throw new RuntimeException ("Este ingresso não está disponível para venda.");
        }
    }


}
