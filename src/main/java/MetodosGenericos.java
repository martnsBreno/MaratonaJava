import GenericsClasses.Carro;

import java.util.ArrayList;
import java.util.List;

public class MetodosGenericos {
    public static void main(String[] args) {
        criarArrayComUmObjeto(new Carro("BMW"));
    }

    private static <T> void criarArrayComUmObjeto(T t) {
        List<T> listist = new ArrayList<>();
        listist.add(t);
        System.out.println(listist);
    }
}
