package com.lowton.refactoring.first;

public class Movie {
    public static final int CHILDRENSS = 2;
    public static final int REGULAR = 0;
    public static final int NEW = 1;

    private String _title;
    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public double getCharge(int daysRented) {
        double result = 0;
        // Определение суммы для каждой строки
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENSS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }
        return result;
    }

    public int getFrequentRenterPoints(int daysRented) {
        int result = 0;
        // Начисление бонусных очков
        result++;

        // Бонус за двухдневный прокат новинки
        if ((getPriceCode() == Movie.NEW) && daysRented > 1) result++;
        return result;
    }
}
