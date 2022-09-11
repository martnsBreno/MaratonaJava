package LambdasTests;

import LambdasTests.services.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodReference01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(
                new Anime("One Piece", 1020),
                new Anime("Sono Bisque", 12),
                new Anime("Fate", 80),
                new Anime("Naruto", 700)));
//        Collections.sort(animeList, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
//        Collections.sort(animeList, AnimeComparators::CompareByTitle);
        Collections.sort(animeList, AnimeComparators::CompareByEpisodes);
        System.out.println(animeList);
    }
}
