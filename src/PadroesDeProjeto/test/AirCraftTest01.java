package PadroesDeProjeto.test;

import PadroesDeProjeto.dominio.AircraftSingletonLazy;

public class AirCraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        AircraftSingletonLazy AircraftSingletonLazy = PadroesDeProjeto.dominio.AircraftSingletonLazy.getInstance();
        System.out.println(AircraftSingletonLazy.bookSeat(seat));
    }
}
