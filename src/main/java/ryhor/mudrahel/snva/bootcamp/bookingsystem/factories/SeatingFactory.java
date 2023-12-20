package ryhor.mudrahel.snva.bootcamp.bookingsystem.factories;

import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.Seating;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.SeatingImpl;

import java.util.ArrayList;
import java.util.List;

public class SeatingFactory {
    public static List<Seating> generateSeating() {
        List seats = new ArrayList();
        seats.add(new SeatingImpl(50));
        seats.add(new SeatingImpl(100));

        return seats;
    }
}
