import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashmapTest03 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Breno Martins");
        Consumidor consumidor2 = new Consumidor("Fate Santos");
//        System.out.println(consumidor1);
//        System.out.println(consumidor2);

        Manga manga1 = new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d, 10);
        Manga manga2 = new Manga(2L, "Fate Series", 150.5d, 20);
        Manga manga3 = new Manga(1L, "One Piece", 100d, 50);
        Manga manga4 = new Manga(4L, "Beserk", 100.5d, 70);
        Manga manga5 = new Manga(4L, "Kanojo Okarimasu", 50d, 0);

        List<Manga> consumidor2MangaList = List.of(manga2, manga1, manga5);
        List<Manga> consumidor1MangaList = List.of(manga1, manga2, manga3, manga4, manga5);
        Map<Consumidor, List<Manga>> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, consumidor1MangaList);
        consumidorManga.put(consumidor2, consumidor2MangaList);

        for(Map.Entry<Consumidor, List<Manga>> entry : consumidorManga.entrySet()) {
            System.out.println("Consumidor " + entry.getKey().getNome() + " Possui os seguintes mangás: ");
            System.out.println("--------------------");
            for (Manga manga : entry.getValue()) {
                System.out.println(manga.getNomeManga());
            }

        }

    }
}
