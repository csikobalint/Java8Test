package chapter6;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by eblicsi on 8/4/2016.
 */
public class PrimeCollectorTest {
    public static void main(String... args){
        final Map<Boolean, List<Integer>> booleanListMap = partitionPrimes(24);
        System.out.println("Primes");
        System.out.println(booleanListMap.get(true));
        System.out.println("Non-Primes");
        System.out.println(booleanListMap.get(false));


        System.out.println("##########################");



    }



    public static Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    private static boolean isPrime(Integer candidate) {
        int candidateRoot = (int)Math.sqrt((double)candidate);
        return IntStream.rangeClosed(2,candidateRoot).noneMatch(i -> candidate % i == 0);
    }

}
