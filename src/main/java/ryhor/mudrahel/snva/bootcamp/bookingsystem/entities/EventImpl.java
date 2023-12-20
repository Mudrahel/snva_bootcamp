package ryhor.mudrahel.snva.bootcamp.bookingsystem.entities;

public class EventImpl implements Event {
    private Seating seating;
    private Show show;

    public EventImpl() {
    }

    public EventImpl(Seating seating, Show show) {
        this.seating = seating;
        this.show = show;
    }

    public Seating getSeating() {
        return seating;
    }

    @Override
    public String getEventInfo() {
        return show.getTitle() + " show will be played, seats: " + seating.getSeats();
    }
}
