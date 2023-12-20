package ryhor.mudrahel.snva.bootcamp.bookingsystem.entities;

import java.util.HashMap;
import java.util.Map;

public class TicketBookerImpl implements TicketBooker {
    Map<Seating, Integer> reservation;

    public TicketBookerImpl() {
        this.reservation = new HashMap<Seating, Integer>();
    }

    @Override
    public void book(Seating seating, int book) {
        if (!reservation.containsKey(seating)) {
            reservation.put(seating, seating.getSeats());
        }

        int remaining = reservation.get(seating);
        if (remaining > 0 && remaining >= book) {
            remaining -= book;
            reservation.put(seating, remaining);
            System.out.println("Booked " + book + " seats. remaining: " + remaining);
        } else {
            System.out.println("Failed to book " + book + " seats. Not enough available seat. Only " + remaining + " left");
        }
    }
}
