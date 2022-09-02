package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {

    public static void main(String[] args) {
        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99),
                new Lightnovel("Classroom of the Elite", 2.99),
                new Lightnovel("Konosuba", 3.50),
                new Lightnovel("Boku no Hero", 3.00),
                new Lightnovel("Tensei Shittara", 8.50),
                new Lightnovel("One Punch Man", 9.99),
                new Lightnovel("Solo Leveling", 7.99)));

        List<String> collectedStream = lightnovels.stream().sorted(Comparator.comparing(Lightnovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4).limit(3).map(ln -> ln.getTitle())
                .collect(Collectors.toList());

        System.out.println(collectedStream);

    }


}
