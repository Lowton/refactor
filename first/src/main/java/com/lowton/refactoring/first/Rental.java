package com.lowton.refactoring.first;

public class Rental {
    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public double getCharge() {
        double result = 0;
        // Определение суммы для каждой строки
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENSS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        // Начисление бонусных очков
        frequentRenterPoints++;

        // Бонус за двухдневный прокат новинки
        if ((getMovie().getPriceCode() == Movie.NEW) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
