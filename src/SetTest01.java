import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> meusMangasSet = new HashSet<>();
        meusMangasSet.add(new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d, 0));
        meusMangasSet.add(new Manga(2L, "Fate Series", 150.5d, 5));
        meusMangasSet.add(new Manga(2L, "Fate Series", 150.5d, 5));
        meusMangasSet.add(new Manga(1L, "One Piece", 100d, 10));
        meusMangasSet.add(new Manga(4L, "Beserk", 100.5d, 15));

        for (Manga manga : meusMangasSet) {
            System.out.println(manga);
        }

        //LinkedHashSet mantém a ordem de inserçao
    }
}
