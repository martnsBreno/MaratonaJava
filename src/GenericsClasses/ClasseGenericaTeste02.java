package GenericsClasses;

import service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTeste02 {
    public static void main(String[] args) {

        List<Carro> carrosDispo = new ArrayList<>(List.of(new Carro("Chevete"), new Carro("Supra")));
        List<Barco> barcossDispo = new ArrayList<>(List.of(new Barco("Iate"), new Barco("Canoa")));

        RentalService<Carro> rentalServiceCarro = new RentalService<>(carrosDispo);
        Carro carro = rentalServiceCarro.buscarObjetoDisponivel();
        System.out.println("Buscando Carro Disponivel");
        rentalServiceCarro.retornarBarcoAlugado(carro);

        System.out.println("---------------------------------");

        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcossDispo);
        Barco barco = rentalServiceBarco.buscarObjetoDisponivel();
        System.out.println("Buscando Carro Disponivel");
        rentalServiceBarco.retornarBarcoAlugado(barco);
    }
}
