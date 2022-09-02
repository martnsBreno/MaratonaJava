package LambdasTests;

import LambdasTests.services.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(
                new Anime("One Piece", 1020),
                new Anime("Sono Bisque", 12),
                new Anime("Fate", 80),
                new Anime("Naruto", 700)));
        AnimeComparators animeComparators = new AnimeComparators();
        animeList.sort(animeComparators::CompareByEpisodesNonStatic);
        System.out.println(animeList);
    }
}
