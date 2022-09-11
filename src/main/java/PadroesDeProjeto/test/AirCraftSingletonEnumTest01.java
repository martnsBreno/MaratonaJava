package PadroesDeProjeto.test;

import PadroesDeProjeto.dominio.AircraftSingletonEnum;

public class AirCraftSingletonEnumTest01 {
    public static void main(String[] args) {
        booSeat("1A");
        booSeat("1A");
    }

    private static void booSeat(String seat) {
        System.out.println(AircraftSingletonEnum.INSTANCE);
        AircraftSingletonEnum aircraftSingletonEnum = AircraftSingletonEnum.INSTANCE;
        System.out.println(aircraftSingletonEnum.booSeat(seat));
    }
}
