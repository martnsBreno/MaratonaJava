package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99, Category.FANTASY),
                new Lightnovel("Classroom of the Elite", 2.99, Category.DRAMA),
                new Lightnovel("Konosuba", 3.50, Category.FANTASY),
                new Lightnovel("Boku no Hero", 3.00, Category.FANTASY),
                new Lightnovel("Tensei Shittara", 8.50, Category.FANTASY),
                new Lightnovel("Sono Bisque", 9.99, Category.ROMANCE),
                new Lightnovel("Solo Leveling", 7.99, Category.FANTASY)));

        Map<PROMOTION, List<Lightnovel>> promotionListMap = lightnovels.stream()
                .collect(Collectors.groupingBy(ln ->
                        ln.getPrice() < 6 ? PROMOTION.UNDER_PROMOTION : PROMOTION.NORMAL_PRICE
                ));

        System.out.println(promotionListMap);

        Map<Category, Map<PROMOTION, List<Lightnovel>>> mapMap = lightnovels.stream().collect(Collectors.groupingBy(Lightnovel::getCategory,
                Collectors.groupingBy(
                        ln -> ln.getPrice() < 6.00 ? PROMOTION.UNDER_PROMOTION : PROMOTION.NORMAL_PRICE)));

        System.out.println("-----------");
        System.out.println(mapMap);
    }
}
