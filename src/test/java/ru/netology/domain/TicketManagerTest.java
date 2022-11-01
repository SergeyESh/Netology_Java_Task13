package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager();

    Ticket ticket1 = new Ticket(1, 1299, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2199, "VKO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 3239, "DME", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 239, "SVO", "KZN", 95);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
    }

    @Test
    void findAll() {
        Ticket[] expected = { ticket1, ticket4 };
        Ticket[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }
}