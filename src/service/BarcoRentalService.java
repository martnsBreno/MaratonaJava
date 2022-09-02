package service;

import GenericsClasses.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentalService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(
            new Barco("Iate"),
            new Barco("Canoa")));

    public Barco buscarBarcosDisponivel() {
        System.out.println("Buscando Barco Disponivel....");
        Barco Barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando Barco: " + Barco);
        System.out.println(barcosDisponiveis);
        return Barco;
    }

    public void retornarBarcoAlugado(Barco Barco) {
        System.out.println("Devolvendo o Barco" + Barco);
        barcosDisponiveis.add(Barco);
        System.out.println("Barcos Disponiveis para alugar: ");
        System.out.println(barcosDisponiveis);
    }
}