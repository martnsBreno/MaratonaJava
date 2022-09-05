package Streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99, Category.FANTASY),
                new Lightnovel("Classroom of the Elite", 2.99, Category.DRAMA),
                new Lightnovel("Konosuba", 3.50, Category.FANTASY),
                new Lightnovel("Boku no Hero", 3.00, Category.FANTASY),
                new Lightnovel("Tensei Shittara", 8.50, Category.FANTASY),
                new Lightnovel("Sono Bisque", 9.99, Category.ROMANCE),
                new Lightnovel("Solo Leveling", 7.99, Category.FANTASY)));

        Map<Category, Long> collect = lightnovels.stream().collect(Collectors.groupingBy(Lightnovel::getCategory, Collectors.counting()));
        System.out.println(collect);

        Map<Category, Optional<Lightnovel>> collect1 = lightnovels.stream()
                .collect(Collectors.groupingBy(Lightnovel::getCategory, Collectors.maxBy(Comparator.comparing(Lightnovel::getPrice))));
        System.out.println(collect1);

        Map<Category, Lightnovel> collect2 = lightnovels.stream().collect(Collectors.groupingBy(Lightnovel::getCategory,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(Lightnovel::getPrice)), Optional::get)));

        System.out.println(collect2);

        Map<Category, Lightnovel> collect3 = lightnovels.stream()
                .collect(Collectors.toMap(Lightnovel::getCategory, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Lightnovel::getPrice))));

        System.out.println(collect3);
    }
}
