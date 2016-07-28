package common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Bálint on 2016. 07. 28..
 */
public class Transactions {
    public static final String CAMBRIDGE = "Cambridge";
    public static final String MILAN = "Milan";

    private static Trader raoul = new Trader("Raoul", CAMBRIDGE);
    private static Trader mario = new Trader("Mario", MILAN);
    private static Trader alan = new Trader("Alan", CAMBRIDGE);
    private static Trader brian = new Trader("Brian", CAMBRIDGE);


    private static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300, "HUF"),
            new Transaction(raoul, 2012, 1000, "EUR"),
            new Transaction(raoul, 2011, 400, "HUF"),
            new Transaction(mario, 2012, 710, "EUR"),
            new Transaction(mario, 2012, 700, "USD"),
            new Transaction(alan, 2012, 950, "HUF")
    );

    public static List<Transaction> getTransactions(){return transactions;}

}
