package org.balint.exercise1;

/**
 * Created by Bálint on 2016. 07. 21.
 */
class Trader {
    private final String name;
    private final String city;

    Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    String getName() {
        return name;
    }

    String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
