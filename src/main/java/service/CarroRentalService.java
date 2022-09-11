package service;

import GenericsClasses.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentalService {
    private List<Carro> carrosDisponiveis = new ArrayList<>(List.of(
            new Carro("BMW"),
            new Carro("Mercedez")));

    public Carro buscarCarrosDisponivel() {
        System.out.println("Buscando Carro Disponivel....");
        Carro carro = carrosDisponiveis.remove(0);
        System.out.println("Alugando carro: " + carro);
        System.out.println(carrosDisponiveis);
        return carro;
    }

    public void retornarCarroAlugado(Carro carro) {
        System.out.println("Devolvendo o carro" + carro);
        carrosDisponiveis.add(carro);
        System.out.println("Carros Disponiveis para alugar: ");
        System.out.println(carrosDisponiveis);
    }
}
