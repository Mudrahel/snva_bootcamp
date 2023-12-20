package ryhor.mudrahel.snva.bootcamp.bookingsystem.factories;

import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.Event;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.EventImpl;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.Seating;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.Show;

import java.util.ArrayList;
import java.util.List;

public class EventsFactory {

    public static List<Event> generateEvents(List<Show> shows, List<Seating> rooms) {
        List<Event> events = new ArrayList<>();

        int i = 0;
        for (Show show : shows) {
            events.add(new EventImpl(rooms.get(i), show));
            i++;
        }

        return events;
    }
}
