package Optional;

import Optional.MangaRepo.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {

        Optional<Manga> sono_bisque = MangaRepository.findByTitle("Overlord");
        sono_bisque.ifPresent(m -> m.setTitle(m.getTitle() + " Volume 2"));
        System.out.println(sono_bisque);

        Manga mangaFoundWithId = MangaRepository.findById(1)
                .orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaFoundWithId);

        Manga mangaCreated = MangaRepository.findByTitle("Fate")
                .orElse(new Manga(3, "Fate", 162));

        System.out.println(mangaCreated);
    }
}
