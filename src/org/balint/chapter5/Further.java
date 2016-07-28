package org.balint.chapter5;

import common.Dish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by eblicsi on 7/24/2016.
 */
public class Further {
    public static void main(String... args) {

        List<Dish> menu = Arrays.asList(
                new Dish("puffasztott rizs", 100),
                new Dish("makosteszta", 600),
                new Dish("youghurt", 30),
                new Dish("sult hal", 800),
                new Dish("borsoleves", 200),
                new Dish("derelye", 500),
                new Dish("pacal", 400),
                new Dish("rizi-bizi", 120)
        );

        //non-effective due
        int calories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("calories: " + calories);

        //more effective as uses IntStream
        int calories2 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("calories2: " + calories2);

        //converting a numeric stream to boxed
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        System.out.println("########");
        stream.forEach(System.out::println);
        System.out.println("########");

        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println("max claories = " + maxCalories.orElse(-1));
        List<Dish> emptyMenu = new ArrayList<>();
        OptionalInt emptyMax = emptyMenu.stream().mapToInt(Dish::getCalories).max();
        System.out.println(emptyMax.orElse(-1));



        header("Numeric ranges");
        IntStream evenNumbers = IntStream.range(0, 100).filter(n -> n % 2 == 0);
        evenNumbers.forEach(System.out::println);
        System.out.println("Pythageorean triples");
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).
                boxed(). //generate a as objects
                flatMap(a ->
                IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b ->
                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)}
                        )
        );
        pythagoreanTriples.limit(50).forEach(t ->
                System.out.println(t[0] + " " + t[1] + " " + t[2])
        );

        header("Building streams");
        Stream<String> stringStream = Stream.of("alma", "a", "fa", "alatt");
        stringStream.map(String::toUpperCase).forEach(System.out::println);

        header("Streams from files");
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("C:\\Users\\eblicsi\\github\\Java8Test\\Java8Test\\src\\org\\balint\\chapter5\\data.txt"))){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("uniqueWords = " + uniqueWords);

        header("Iterate");
        Stream.iterate(0,n -> n +2).limit(10).forEach(System.out::println);

        header("Iterate Fibonacci tuples");
        Stream.iterate(new int[]{0,1}, t-> new int[]{t[1], t[0] + t[1]}).limit(20).forEach(t -> System.out.println(t[0] +" " +  t[1]));

        header("Generate");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }

    private static void header(String title) {
        System.out.println("########");
        System.out.println(title);
    }




}