package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99),
                new Lightnovel("Classroom of the Elite", 2.99),
                new Lightnovel("Konosuba", 3.50),
                new Lightnovel("Boku no Hero", 3.00),
                new Lightnovel("Tensei Shittara", 8.50),
                new Lightnovel("One Punch Man", 9.99),
                new Lightnovel("Solo Leveling", 7.99)));

        System.out.println(lightnovels.stream().count());
        System.out.println(lightnovels.stream().collect(Collectors.counting()));

        lightnovels.stream().max(Comparator.comparing(Lightnovel::getPrice)).ifPresent(System.out::println);
        lightnovels.stream().collect(Collectors.maxBy(Comparator.comparing(Lightnovel::getPrice))).ifPresent(System.out::println);

        System.out.println(lightnovels.stream().mapToDouble(Lightnovel::getPrice).sum());
        System.out.println(lightnovels.stream().collect(Collectors.summingDouble(Lightnovel::getPrice )));

        DoubleSummaryStatistics collectSummarizing = lightnovels.stream().collect(Collectors.summarizingDouble(Lightnovel::getPrice));
        System.out.println(collectSummarizing);
        System.out.println("----------------");
        String collected = lightnovels.stream().map(Lightnovel::getTitle).collect(Collectors.joining(", "));
        System.out.println(collected);
    }
}
