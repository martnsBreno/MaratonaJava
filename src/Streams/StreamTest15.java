package Streams;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

import static Streams.PROMOTION.NORMAL_PRICE;
import static Streams.PROMOTION.UNDER_PROMOTION;

public class StreamTest15 {
    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99, Category.FANTASY), new Lightnovel("Classroom of the Elite", 2.99, Category.DRAMA), new Lightnovel("Konosuba", 3.50, Category.FANTASY), new Lightnovel("Boku no Hero", 3.00, Category.FANTASY), new Lightnovel("Tensei Shittara", 8.50, Category.FANTASY), new Lightnovel("Sono Bisque", 9.99, Category.ROMANCE), new Lightnovel("Solo Leveling", 7.99, Category.FANTASY)));
        Map<Category, DoubleSummaryStatistics> collect = lightnovels.stream()
                .collect(Collectors.groupingBy(Lightnovel::getCategory, Collectors.summarizingDouble(Lightnovel::getPrice)));
        System.out.println(collect);

        Map<Category, Set<PROMOTION>> collect1 = lightnovels.stream()
                .collect(Collectors.groupingBy(Lightnovel::getCategory, Collectors.mapping(StreamTest15::getPromotion, Collectors.toSet())));

        System.out.println(collect1);
    }


    private static PROMOTION getPromotion(Lightnovel ln) {
        return ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}
