package LambdasTests;

import LambdasTests.services.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest04 {
    public static void main(String[] args) {

        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animenList = new ArrayList<>(List.of(new Anime("Beserk", 43), new Anime("One Piece", 1100)));
        animenList.sort(animeComparators::CompareByEpisodesNonStatic);
    }
}
