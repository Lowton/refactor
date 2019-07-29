package com.lowton.refactoring.first.price;

import com.lowton.refactoring.first.Movie;

public class ChildrenPrice extends Price {
    @Override
    public int getPriceCode() {
        return Movie.CHILDRENSS;
    }
}
