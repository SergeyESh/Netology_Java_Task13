package ru.netology.domain;

import ru.netology.repository.TicketRepository;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    /*public Ticket[] searchBy(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket: repository.getItems()) {
            if (matches(ticket, text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }*/

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket: repository.getItems()) {
            if (matches(ticket, from)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
            if (matches(ticket, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String search) {
        if (ticket.getFrom().contains(search)) {
            return true;
        } else if (ticket.getTo().contains(search)) {
            return true;
        }
        return false;
    }

}
