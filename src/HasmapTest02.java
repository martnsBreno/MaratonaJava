import java.util.HashMap;
import java.util.Map;

public class HasmapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Breno Martins");
        Consumidor consumidor2 = new Consumidor("Rin Santos");
        System.out.println(consumidor1);
        System.out.println(consumidor2);

        Manga manga1 = new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d, 10);
        Manga manga2 = new Manga(2L, "Fate Series", 150.5d, 20);
        Manga manga3 = new Manga(1L, "One Piece", 100d, 50);
        Manga manga4 = new Manga(4L, "Beserk", 100.5d, 70);
        Manga manga5 = new Manga(4L, "Kanojo Okarimasu", 50d, 0);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, manga1);
        consumidorManga.put(consumidor2, manga1);
        for(Map.Entry<Consumidor, Manga> entry: consumidorManga.entrySet()) {
            System.out.println("Cliente:" + entry.getKey().getNome() + " Manga Adquirido: " + entry.getValue().getNomeManga());
        }
    }
}
