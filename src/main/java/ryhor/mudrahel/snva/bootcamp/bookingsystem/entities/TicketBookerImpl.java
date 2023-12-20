package ryhor.mudrahel.snva.bootcamp.bookingsystem.entities;

import java.util.HashMap;
import java.util.Map;

public class TicketBookerImpl implements TicketBooker {
    Map<Seating, Integer> reservation;

    public TicketBookerImpl() {
        this.reservation = new HashMap<Seating, Integer>();
    }

    @Override
    public void book(Seating seating, int seats) {
        if (!reservation.containsKey(seating)) {
            reservation.put(seating, seating.getSeats());
        }

        int remaining = reservation.get(seating);
        if (remaining > 0 && remaining >= seats) {
            remaining -= seats;
            reservation.put(seating, remaining);
            System.out.println("Booked " + seats + " seats. remaining: " + remaining);
        } else {
            System.out.println("Failed to book " + seats + " seats. Not enough available seat. Only " + remaining + " left");
        }
    }
}
