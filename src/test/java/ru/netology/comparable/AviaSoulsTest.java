package ru.netology.comparable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Берлин", 1000, 10, 11);
    Ticket ticket2 = new Ticket("Москва", "Париж", 2000, 12, 15);
    Ticket ticket3 = new Ticket("Москва", "Лондон", 1000, 17, 19);
    Ticket ticket4 = new Ticket("Москва", "Лондон", 5000, 18, 23);
    Ticket ticket5 = new Ticket("Москва", "Лондон", 3000, 20, 21);


    // 1) Тест, когда цена билета меньше, чем у второго

    @Test
    public void shouldTicketPriceLower() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    // 2) Тест, когда цена билета больше, чем у второго

    @Test
    public void shouldTicketPriceHigher() {
        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    // 3) Тест, когда цены билетов равны

    @Test
    public void shouldTicketPriceEquals() {
        int expected = 0;
        int actual = ticket3.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    // 4) Тест, на метод поиска search с сортировкой в порядке возрастания цены

    @Test
    public void shouldCorrectSearch() {
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3); // 1000 цена
        manager.add(ticket4); // 5000 цена
        manager.add(ticket5); // 3000 цена
        Ticket[] expected = {ticket3, ticket5, ticket4};
        Ticket[] actual = manager.search("Москва", "Лондон");
        Assertions.assertArrayEquals(expected, actual);
    }

    // 5) Тест, когда время перелета билета меньше, чем у второго

    @Test
    public void shouldFlyTimeLower() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        int expected = -1;
        int actual = ticketTimeComparator.compare(ticket1, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    // 6) Тест, когда время перелета билета больше, чем у второго

    @Test
    public void shouldFlyTimeHigher() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket2);
        int expected = 1;
        int actual = ticketTimeComparator.compare(ticket2, ticket1);
        Assertions.assertEquals(expected, actual);
    }

    // 7) Тест, когда время перелета одинаково

    @Test
    public void shouldFlyTimeEquals() {
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        AviaSouls manager = new AviaSouls();
        manager.add(ticket1);
        manager.add(ticket5);
        int expected = 0;
        int actual = ticketTimeComparator.compare(ticket1, ticket5);
        Assertions.assertEquals(expected, actual);
    }

    // 8) Тест, на метод поиска searchAndSortBy с сортировкой по времени перелета

    @Test
    public void shouldCorrectSearchAndSortBy() {
        AviaSouls manager = new AviaSouls();
        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3); // 2 часа
        manager.add(ticket4); // 5 часов
        manager.add(ticket5); // 1 час
        Ticket[] expected = {ticket5, ticket3, ticket4};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Лондон", ticketTimeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
