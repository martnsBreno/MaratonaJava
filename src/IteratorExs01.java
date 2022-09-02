import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExs01 {
    public static void main(String[] args) {
        List<Manga> meusMangas = new ArrayList<>();
        meusMangas.add(new Manga(3L, "Sono Bisque Doll wa Koi o Suru", 102d, 10));
        meusMangas.add(new Manga(2L, "Fate Series", 150.5d, 20));
        meusMangas.add(new Manga(1L, "One Piece", 100d, 50));
        meusMangas.add(new Manga(4L, "Beserk", 100.5d, 70));
        meusMangas.add(new Manga(4L, "Kanojo Okarimasu", 50d, 0));

        System.out.println(meusMangas);
        System.out.println("--------");

//        Iterator<Manga> iteratorMeusMangas = meusMangas.iterator();
//        while (iteratorMeusMangas.hasNext()) {
//            Manga next = iteratorMeusMangas.next();
//            if(next.getQuantidade() == 0) iteratorMeusMangas.remove();
//        }

        meusMangas.removeIf(RefVar -> RefVar.getQuantidade() == 0);
        System.out.println(meusMangas);

    }
}
