package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTests06 {
    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of
                (new Lightnovel("Overlord", 3.99),
                new Lightnovel("Classroom of the Elite", 2.99),
                new Lightnovel("Konosuba", 3.50),
                new Lightnovel("Boku no Hero", 3.00),
                new Lightnovel("Tensei Shittara", 8.50),
                new Lightnovel("One Punch Man", 9.99),
                new Lightnovel("Solo Leveling", 7.99)));

        boolean anyMatch = lightnovels.stream().anyMatch(ln -> ln.getPrice() < 10.00);
        boolean anyMatch2 = lightnovels.stream().allMatch(ln -> ln.getPrice() >  2.00);
        boolean anyMatch3 = lightnovels.stream().noneMatch(ln -> ln.getPrice() ==  2.00);

        lightnovels.stream().filter(ln -> ln.getPrice() > 3).findAny()
                .ifPresent(System.out::println);

        lightnovels.stream().filter(ln -> ln.getPrice() > 3.00).findFirst()
                        .ifPresent(System.out::println);

        System.out.println(anyMatch);
        System.out.println("-----------------");
        System.out.println(anyMatch2);
        System.out.println("----------------");
        System.out.println(anyMatch3);
    }
}
