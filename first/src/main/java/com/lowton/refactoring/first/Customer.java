package com.lowton.refactoring.first;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String staitment() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Прокат " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            thisAmount = amountFor(each);

            // Начисление бонусных очков
            frequentRenterPoints++;

            // Бонус за двухдневный прокат новинки
            if ((each.getMovie().getPriceCode() == Movie.NEW) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // Вывод результатов для каждого проката
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // Добавление колонтитула

        result += "Сумма задолженности: " + String.valueOf(totalAmount) + "\n";
        result += "Вы заработали " + String.valueOf(frequentRenterPoints) + " бонусных очков!\n";
        return result;
    }

    private double amountFor(Rental aRental) {
        double result = 0;
        // Определение суммы для каждой строки
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (aRental.getDaysRented() > 2)
                    result += (aRental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW:
                result += aRental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENSS:
                result += 1.5;
                if (aRental.getDaysRented() > 3)
                    result += (aRental.getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }
}
