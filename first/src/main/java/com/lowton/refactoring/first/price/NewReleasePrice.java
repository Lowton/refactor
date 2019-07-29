package com.lowton.refactoring.first.price;

import com.lowton.refactoring.first.Movie;

public class NewReleasePrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.NEW;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
