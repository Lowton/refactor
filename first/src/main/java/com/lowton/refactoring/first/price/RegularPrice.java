package com.lowton.refactoring.first.price;

import com.lowton.refactoring.first.Movie;

public class RegularPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }
}
