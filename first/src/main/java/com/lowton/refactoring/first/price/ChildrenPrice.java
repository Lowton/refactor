package com.lowton.refactoring.first.price;

import com.lowton.refactoring.first.Movie;

public class ChildrenPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENSS;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
