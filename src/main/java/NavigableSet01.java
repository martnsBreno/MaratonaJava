import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartPhoneMarcaCompare implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class mangaPrecoComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavigableSet01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartPhoneMarcaCompare());
        Smartphone smartphone = new Smartphone("1513", "Nokia");
        set.add(smartphone);
        System.out.println(set);

        NavigableSet<Manga> mangaSet = new TreeSet<>(new mangaPrecoComparator());
        mangaSet.add(new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d));
        mangaSet.add(new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d));
        mangaSet.add(new Manga(2L, "Fate Series", 150.5d));
        mangaSet.add(new Manga(1L, "One Piece", 100d));
        mangaSet.add(new Manga(4L, "Beserk", 100.5d));

        for (Manga manga : mangaSet) {
            System.out.println(manga);
        }

        //lower, floor, higher and ceiling
        //pollfirst
        Manga brabos = (new Manga(32L, "Beserk e vários outros", 100.5d, 20));
        System.out.println("----------------");
        System.out.println(mangaSet.lower(brabos));
    }
}
