package org.balint.exercise1;

/**
 * Created by Bálint on 2016. 07. 21.
 */
class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    Trader getTrader() {
        return trader;
    }

    int getYear() {
        return year;
    }

    int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
