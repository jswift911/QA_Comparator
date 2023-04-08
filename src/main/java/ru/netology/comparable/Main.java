package ru.netology.comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("Москва", "Берлин", 5000, 10, 18);
        Ticket ticket2 = new Ticket("Москва", "Париж", 7000, 12, 13);
        Ticket ticket3 = new Ticket("Москва", "Лондон", 1000, 17, 20);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3};
        //Arrays.sort(tickets);
        Arrays.sort(tickets, ticketTimeComparator);

    }
}