import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>();

        mangas.add("Chainsawman");
        mangas.add("Fate Series");
        mangas.add("One Punch Man");
        mangas.add("One Piece");
        mangas.add("Sono Bisque Doll wa Koi o Suru");
        mangas.add("Attack On Titan");

        Collections.sort(mangas);

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(10901D);
        dinheiros.add(1111111D);
        dinheiros.add(10D);


        Collections.sort(dinheiros);

        for (Double dinheiro : dinheiros) {
            System.out.println(dinheiro);
        }
        System.out.println("-----------------");
        for(String manga : mangas) {
            System.out.println(manga);
        }
    }
}
