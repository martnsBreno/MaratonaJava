import java.util.*;

class sortMangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return o1.getId().compareTo(o2.getId());
    }

}


public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> meusMangas = new LinkedList<>();
        sortMangaByIdComparator sortMangaByIdComparator = new sortMangaByIdComparator();
        meusMangas.add(new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d));
        meusMangas.add(new Manga(2L, "Fate Series", 150.5d));
        meusMangas.add(new Manga(1L, "One Piece", 100d));
        meusMangas.add(new Manga(4L, "Beserk", 100.5d));

        for (Manga mangas : meusMangas) {
            System.out.println(mangas);
        }

        System.out.println("---------------");

        Collections.sort(meusMangas);

        for (Manga mangas : meusMangas) {
            System.out.println(mangas);
        }

        System.out.println("---------------");

        Collections.sort(meusMangas, new sortMangaByIdComparator());
        for (Manga mangas : meusMangas) {
            System.out.println(mangas);
        }

        Manga mangaToSearch = new Manga(1L, "One Piece", 100d);
        System.out.println("Binary Search");
        System.out.println(Collections.binarySearch(meusMangas, mangaToSearch, sortMangaByIdComparator));

    }
}
