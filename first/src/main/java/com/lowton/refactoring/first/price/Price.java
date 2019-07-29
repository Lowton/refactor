package com.lowton.refactoring.first.price;

import com.lowton.refactoring.first.Movie;

public abstract class Price {
    public abstract int getPriceCode();
    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}
