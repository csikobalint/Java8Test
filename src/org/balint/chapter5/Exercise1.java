package org.balint.chapter5;

import common.Trader;
import common.Transaction;
import common.Transactions;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

/**
 * Created by Bálint on 2016. 07. 21.
 */
public class Exercise1 {

    public static void main(String... args) {



        System.out.println("Exercises from Java 8 in action");

        System.out.println("#1 Find all transactions in the year 2011 and sor them bye value (small to high)");
        Transactions.getTransactions().stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);

        System.out.println("#2 What are all the unique cities where the traders work?");
        Transactions.getTransactions().stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

        System.out.println("#3 Find all traders from Cambridge and sort them by name");
        Transactions.getTransactions().stream().map(Transaction::getTrader).distinct().filter(t -> t.getCity().equals(Transactions.CAMBRIDGE)).sorted(comparing(Trader::getName)).forEach(System.out::println);

        System.out.println("#4 return a string of all traders' names sorted alphabetically");
        System.out.println(Transactions.getTransactions().stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(joining()));

        System.out.println("#5 are any traders based in Milan?");
        System.out.println(Transactions.getTransactions().stream().anyMatch(t -> t.getTrader().getCity().equals(Transactions.MILAN)));

        System.out.println("#6 Print all transactions' values from the traders living in Cambridge.");
        Transactions.getTransactions().stream().filter(t -> t.getTrader().getCity().equals(Transactions.CAMBRIDGE)).map(Transaction::getValue).forEach(System.out::println);

        System.out.println("#7 What's the highest value of the transactions?");
        System.out.println(Transactions.getTransactions().stream().map(Transaction::getValue).reduce(Integer::max));

        System.out.println("#8 Find the transaction with the smallest value");
        System.out.println(Transactions.getTransactions().stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2));

    }


}
