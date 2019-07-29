package com.lowton.refactoring.first;

import com.lowton.refactoring.first.price.ChildrenPrice;
import com.lowton.refactoring.first.price.NewReleasePrice;
import com.lowton.refactoring.first.price.Price;
import com.lowton.refactoring.first.price.RegularPrice;

public class Movie {
    public static final int CHILDRENSS = 2;
    public static final int REGULAR = 0;
    public static final int NEW = 1;

    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        this._title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENSS:
                _price = new ChildrenPrice();
                break;
            case NEW:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Неверное значение Price Code");
        }
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}
