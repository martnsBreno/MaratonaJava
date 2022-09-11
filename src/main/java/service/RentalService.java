package service;

import GenericsClasses.Barco;
import GenericsClasses.Carro;

import java.util.ArrayList;
import java.util.List;

public class RentalService<T> {
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel() {
        System.out.println("Buscando Objeto Disponivel....");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando Objeto: " + t);
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarBarcoAlugado(T t) {
        System.out.println("Devolvendo o Objeto" + t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos Disponiveis para alugar: ");
        System.out.println(objetosDisponiveis);
    }
}
