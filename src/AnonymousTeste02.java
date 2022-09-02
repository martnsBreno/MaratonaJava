import GenericsClasses.Barco;
import GenericsClasses.Carro;

import java.util.Comparator;
import java.util.List;

public class AnonymousTeste02 {
    public static void main(String[] args) {
        List<Carro> carroList = List.of(new Carro("BMW"), new Carro("Mercedez"));
        carroList.sort(Comparator.comparing(Carro::getNome));
    }
}
