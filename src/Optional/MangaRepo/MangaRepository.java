package Optional.MangaRepo;

import Optional.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga> mangas = List.of(new Manga(1, "Sono Bisque", 84),
            new Manga(2, "Overlord", 200));

    public static Optional<Manga> findByTitle(String title) {
        return findByWhat(m -> m.getTitle().equals(title));
    }

    public static Optional<Manga> findById(Integer id) {
        return findByWhat(m -> m.getId().equals(id));
    }


    public static Optional<Manga> findByWhat(Predicate<Manga> predicate ) {
        Manga found = null;
        for (Manga manga : mangas) {
            if(predicate.test(manga)) found = manga;
        }
         return Optional.ofNullable(found);
    }
}
