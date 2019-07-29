package com.lowton.refactoring.first;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CustomerTest {

    @Test
    void statementTest() {
        final String johnStatement = "Прокат John\n" +
                "\tRats\t8.0\n" +
                "\tCats\t6.0\n" +
                "Сумма задолженности: 14.0\n" +
                "Вы заработали 3 бонусных очков!\n";
        final String aliceStatement = "Прокат Alice\n" +
                "\tDogs\t7.5\n" +
                "Сумма задолженности: 7.5\n" +
                "Вы заработали 1 бонусных очков!\n";

        Movie cats = new Movie("Cats", 1);
        Movie dogs = new Movie("Dogs", 2);
        Movie rats = new Movie("Rats", 0);

        Customer john = new Customer("John");
        Customer alice = new Customer("Alice");

        john.addRental(new Rental(rats, 6));
        john.addRental(new Rental(cats, 2));
        alice.addRental(new Rental(dogs, 7));

        Assertions.assertEquals(johnStatement, john.statement());
        Assertions.assertEquals(aliceStatement, alice.statement());
    }

    @Test
    void htmlStatementTest() {
        final String johnStatement = "<h1>Прокат <em>John</em></h1>" +
                "<p>Rats: 8.0</p>\n" +
                "<p>Cats: 6.0</p>\n" +
                "<p>Сумма задолженности <em>14.0</em></p>\n" +
                "<p>Вы заработали <em>3</em> бонусных очков.</p>";
        final String aliceStatement = "<h1>Прокат <em>Alice</em></h1>" +
                "<p>Dogs: 7.5</p>\n" +
                "<p>Сумма задолженности <em>7.5</em></p>\n" +
                "<p>Вы заработали <em>1</em> бонусных очков.</p>";

        Movie cats = new Movie("Cats", 1);
        Movie dogs = new Movie("Dogs", 2);
        Movie rats = new Movie("Rats", 0);

        Customer john = new Customer("John");
        Customer alice = new Customer("Alice");

        john.addRental(new Rental(rats, 6));
        john.addRental(new Rental(cats, 2));
        alice.addRental(new Rental(dogs, 7));

        Assertions.assertEquals(johnStatement, john.htmlStatement());
        Assertions.assertEquals(aliceStatement, alice.htmlStatement());
    }
}