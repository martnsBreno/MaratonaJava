package Optional;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> optionalS = Optional.ofNullable(findName("Breno"));
        Optional<String> optionalS2 = Optional.ofNullable(findName("breno"));
        String optionalVar = optionalS.orElse("Nao encontrado");
        String optionalVar2 = optionalS2.orElse("Nao encontrado Optional2");
        System.out.println(optionalVar);
        System.out.println(optionalVar2);
        optionalS.ifPresent(s -> System.out.println(s.toUpperCase()));
    }

    private static String findName(String name) {
        List<String> strings = List.of("Breno", "Martins");
        int i = strings.indexOf(name);
        if (i != -1) return strings.get(i);
        return null;
    }
}
