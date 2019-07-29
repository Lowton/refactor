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
        return _movie.getCharge(this._daysRented);
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
