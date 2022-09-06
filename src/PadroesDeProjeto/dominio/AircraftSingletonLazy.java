package PadroesDeProjeto.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonLazy {
    private static AircraftSingletonLazy INSTANCE;
    private final Set<String> avaliableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        avaliableSeats.add("1A");
        avaliableSeats.add("1B");
    }
    public boolean bookSeat(String seat) {
        return avaliableSeats.remove(seat);
    }

    public static AircraftSingletonLazy getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AircraftSingletonLazy("782-9A");
        return INSTANCE;
    }
}
