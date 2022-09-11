package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Ordenar todas as lightnovels por titulo
//Trazer as 3 primeiras lightnovels com o preco menor que 4
public class StreamTest01 {
    public static void main(String[] args) {
        List<String> novelsCheaperThan4 = new ArrayList<>();

        List<Lightnovel> lightnovels = new ArrayList<>(List.of(new Lightnovel("Overlord", 3.99),
                new Lightnovel("Classroom of the Elite", 2.99),
                new Lightnovel("Konosuba", 3.50),
                new Lightnovel("Boku no Hero", 3.00),
                new Lightnovel("Tensei Shittara", 8.50),
                new Lightnovel("One Punch Man", 9.99),
                new Lightnovel("Solo Leveling", 7.99)));

        lightnovels.sort(Comparator.comparing(Lightnovel::getTitle));

        for (Lightnovel lightnovel : lightnovels) {
            if (novelsCheaperThan4.size() < 3)
                if (lightnovel.getPrice() <= 4.00)
                    novelsCheaperThan4.add(lightnovel.getTitle());
            else {
                break;
                }
        }


        System.out.println(lightnovels);
        System.out.println("Primeiras 3 novels com o preco menor que 4 :" + novelsCheaperThan4);
    }
}

