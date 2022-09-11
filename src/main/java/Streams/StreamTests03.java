package Streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamTests03 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();

        List<String> graphicDesigners = List.of("Wildnei Suane", "Catarina Santos");
        List<String> developers = List.of("William", "David", "Harisson");
        List<String> estudantes = List.of("Breno Martins", "Lucas Sao Paulino", "Karolina Silva");

        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(estudantes);

        devdojo.stream().flatMap(Collection::stream)
                .forEach(System.out::println);
    }

}
