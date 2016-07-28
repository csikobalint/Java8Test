package common;

/**
 * Created by Bálint on 2016. 07. 21.
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    private final String currency;

    public Transaction(Trader trader, int year, int value, String currency) {
        this.trader = trader;
        this.year = year;
        this.value = value;
        this.currency = currency;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
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
