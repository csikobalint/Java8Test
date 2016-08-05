package chapter6;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by eblicsi on 8/4/2016.
 */
public class CollectorHarness {
    public static void main(String... args){
        System.out.println("basic collector");
        test(CollectorHarness::partitionPrimes);
        System.out.println("custom collector");
        test(CollectorHarness::partitionPrimesWithCustomCollector);

    }

    private static void test(Function<Integer, Map<Boolean, List<Integer>>> f){
        long fastest = Long.MAX_VALUE;
        for (int i =0; i < 10; i++){
            System.out.println(i);
            long start = System.nanoTime();
//            f.apply(1_000_000);
            f.apply(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println("Fastest execution = " + fastest + " msecs");
        //Benchmarking framework JMH
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n){{
        return IntStream.rangeClosed(2,n).boxed().collect(new PrimeCollector());
    }}


    public static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    private static boolean isPrime(Integer candidate) {
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2,candidateRoot).noneMatch(i -> candidate % i == 0);
    }}
