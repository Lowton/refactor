package com.lowton.refactoring.first;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String _name) {
        this._name = _name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();

        StringBuilder result = new StringBuilder("Прокат " + getName() + "\n");

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            // Вывод результатов для каждого проката
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
        }

        // Добавление колонтитула
        result.append("Сумма задолженности: ").append(getTotalCharge()).append("\n");
        result.append("Вы заработали ").append(getTotalFrequentRenterPoints()).append(" бонусных очков!\n");
        return result.toString();
    }

    public String htmlStatement() {
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("<h1>Прокат <em>" + getName() + "</em></h1>");

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result.append("<p>").append(each.getMovie().getTitle()).append(": ").append(each.getCharge()).append("</p>\n");
        }

        // Добавление колонтитула
        result.append("<p>Сумма задолженности <em>").append(getTotalCharge()).append("</em></p>\n");
        result.append("<p>Вы заработали <em>").append(getTotalFrequentRenterPoints()).append("</em> бонусных очков.</p>");

        return result.toString();
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }
}
