package common;

/**
 * Created by eblicsi on 7/24/2016.
 */
public class Dish {
    private final String name;
    private final int calories;

    public Dish(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}