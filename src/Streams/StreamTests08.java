package Streams;

import java.util.ArrayList;
import java.util.List;

public class StreamTests08 {
    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99),
                new Lightnovel("Classroom of the Elite", 2.99),
                new Lightnovel("Konosuba", 3.50),
                new Lightnovel("Boku no Hero", 3.00),
                new Lightnovel("Tensei Shittara", 8.50),
                new Lightnovel("One Punch Man", 9.99),
                new Lightnovel("Solo Leveling", 7.99)));

        lightnovels.stream().map(Lightnovel::getPrice).filter(price -> price > 3).reduce(Double::sum)
                .ifPresent(System.out::println);
    }
}
