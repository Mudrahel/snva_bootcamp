package ryhor.mudrahel.snva.bootcamp.bookingsystem.entities;

public class SeatingImpl implements Seating {
    private int seats;

    public SeatingImpl(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }


}
