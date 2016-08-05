package chapter6;

import common.Dish;
import common.Dishes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by eblicsi on 8/4/2016.
 */
public class DishesMain {
    public static void main(String... args){
        List<Dish> dishes = Dishes.getDishes().stream().collect(new ToListCollector<Dish>());
        for (Dish dish : dishes) {
            System.out.println(dish);
        }

        System.out.println("###############");
        List<Dish> dishes2 = Dishes.getDishes().stream().collect(ArrayList::new, List::add, List::addAll);
        for (Dish dish : dishes2) {
            System.out.println(dish);
        }
    }
}
