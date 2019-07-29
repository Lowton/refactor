package com.lowton.refactoring.first;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CustomerTest {

    @Test
    void staitment() {
        String johnStaitment = "Прокат John\n" +
                "\tRats\t8.0\n" +
                "\tCats\t6.0\n" +
                "Сумма задолженности: 14.0\n" +
                "Вы заработали 3 бонусных очков!\n";
        String aliceStaitment = "Прокат Alice\n" +
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

        Assertions.assertEquals(johnStaitment, john.statement());
        Assertions.assertEquals(aliceStaitment, alice.statement());
    }
}