package chapter6;

import common.Transaction;
import common.Transactions;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static javafx.scene.input.KeyCode.K;

/**
 * Created by Bálint on 2016. 07. 28..
 */
public class Main {

    public static void main(String... args){

        System.out.println("Organize by currency, oldschool way");

        Map<String, List<Transaction>> grouped = new HashMap<>();

        for (Transaction t :
                Transactions.getTransactions()) {
            if (grouped.get(t.getCurrency()) == null){
                List<Transaction> tList = new ArrayList<>();
                tList.add(t);
                grouped.put(t.getCurrency(), tList);
            } else{
                grouped.get(t.getCurrency()).add(t);
            }
        }

        printMap(grouped);

        System.out.println("---------------------------------------------");
        System.out.println("Organize by collect(groupingBy)");

        Map<String, List<Transaction>> grouped2 = Transactions.getTransactions().stream().collect(groupingBy(Transaction::getCurrency));

        printMap(grouped2);

}

    private static void printMap(Map<String, List<Transaction>> map){
        for (String c :
                map.keySet()) {
            System.out.println(c);
            System.out.println("###########");
            for (Transaction t :
                    map.get(c)) {
                System.out.println(t);
            }
        }

    }

}
