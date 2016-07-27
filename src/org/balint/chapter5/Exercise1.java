package org.balint.chapter5;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

/**
 * Created by Bálint on 2016. 07. 21.
 */
public class Exercise1 {

    private static final String CAMBRIDGE = "Camridge";
    private static final String MILAN = "Milan";

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", CAMBRIDGE);
        Trader mario = new Trader("Mario", MILAN);
        Trader alan = new Trader("Alan", CAMBRIDGE);
        Trader brian = new Trader("Brian", CAMBRIDGE);


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)

        );
        System.out.println("Exercises from Java 8 in action");

        System.out.println("#1 Find all transactions in the year 2011 and sor them bye value (small to high)");
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);

        System.out.println("#2 What are all the unique cities where the traders work?");
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

        System.out.println("#3 Find all traders from Cambridge and sort them by name");
        transactions.stream().map(Transaction::getTrader).distinct().filter(t -> t.getCity().equals(CAMBRIDGE)).sorted(comparing(Trader::getName)).forEach(System.out::println);

        System.out.println("#4 return a string of all traders' names sorted alphabetically");
        System.out.println(transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(joining()));

        System.out.println("#5 are any traders based in Milan?");
        System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals(MILAN)));

        System.out.println("#6 Print all transactions' values from the traders living in Cambridge.");
        transactions.stream().filter(t -> t.getTrader().getCity().equals(CAMBRIDGE)).map(Transaction::getValue).forEach(System.out::println);

        System.out.println("#7 What's the highest value of the transactions?");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max));

        System.out.println("#8 Find the transaction with the smallest value");
        System.out.println(transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2));

    }


}
