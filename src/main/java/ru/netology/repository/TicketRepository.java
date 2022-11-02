package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {

    private Ticket[] items = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[items.length +1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = ticket;
        items = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[items.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : items) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }
}
