package org.balint.excersice1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by Bálint on 2016. 07. 21..
 */
public class Excercise1 {

    public static final String CAMBRIDGE = "Camridge";
    public static final String MILAN = "Milan";

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


        System.out.println("#1 Find all transactions in the year 2011 and sor them bye value (small to high)");
        transactions.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue)).forEach(System.out::println);


    }


}
