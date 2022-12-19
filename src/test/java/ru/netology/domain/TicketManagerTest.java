package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1_000, "SVO", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 200, "SVO", "KZN", 95);
    Ticket ticket3 = new Ticket(3, 3_000, "SVO", "KZN", 95);
    Ticket ticket4 = new Ticket(4, 200, "SVO", "KZN", 95);
    Ticket ticket5 = new Ticket(5, 500, "DME", "KZN", 95);

//    @BeforeEach
//    public void setup() {
//        manager.add(ticket1);
//        manager.add(ticket2);
//        manager.add(ticket3);
//        manager.add(ticket4);
//        manager.add(ticket5);
//
//    }

    @Test
    void shouldFindAll() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket [] expected = { ticket2, ticket4, ticket1, ticket3 };
        Ticket [] actual = manager.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOne() {
        manager.add(ticket1);

        Ticket [] expected = { ticket1 };
        Ticket [] actual = manager.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFind() {

        Ticket [] expected = {};
        Ticket [] actual = manager.findAll("SVO", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }

}