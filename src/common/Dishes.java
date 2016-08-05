package common;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eblicsi on 8/4/2016.
 */
public class Dishes {
    private static List<Dish> menu = Arrays.asList(
            new Dish("puffasztott rizs", 100),
            new Dish("makosteszta", 600),
            new Dish("youghurt", 30),
            new Dish("sult hal", 800),
            new Dish("borsoleves", 200),
            new Dish("derelye", 500),
            new Dish("pacal", 400),
            new Dish("rizi-bizi", 120)
    );

    public static List<Dish> getDishes(){
        return menu;
    }

}
