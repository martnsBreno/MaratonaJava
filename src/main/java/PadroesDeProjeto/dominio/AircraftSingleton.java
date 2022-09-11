package PadroesDeProjeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingleton {
    private static final AircraftSingleton INSTANCE = new AircraftSingleton("783-94");
    private final Set<String> avaliableSeats = new HashSet<>();
    private final String name;

    private AircraftSingleton(String name) {
        this.name = name;
    }

    {
        avaliableSeats.add("1A");
        avaliableSeats.add("1B");
    }
    public boolean bookSeat(String seat) {
        return avaliableSeats.remove(seat);
    }

    public static AircraftSingleton getInstance() {
        return INSTANCE;
    }
}
