package ryhor.mudrahel.snva.bootcamp.bookingsystem;

import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.*;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.factories.EventsFactory;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.factories.SeatingFactory;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.factories.ShowsFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Task. You are tasked with creating a booking system for a theater with different types of shows and seating arrangements.
 * Explain how you would use polymorphism and abstraction to model the diverse shows and handle ticket reservations.
 *
 * Some thinking.
 *  Theater sells *Ticket(s) to a *Shows
 *  a Show has different types (Comedy, Drama, Tragedy, Melodrama)
 *  a Show requires seating arrangement
 *  an Event is a combination of a seating and a Show
 */
public class TheaterImpl {
    public static void main(String[] args) {

        runDemo();

    }

    private static void runDemo(){
        System.out.println("Theater welcomes you sir!");

        List<Show> shows = ShowsFactory.generateShows();
        System.out.println("== Generated shows:\n" + shows.stream()
                .map(Show::getTitle).collect(Collectors.joining("\n")));

        List<Seating> seating = SeatingFactory.generateSeating();
        System.out.println("== Generated seating:\n" + seating.stream()
                .map(s-> String.valueOf(s.getSeats())).collect(Collectors.joining("\n")));

        List<Event> events = EventsFactory.generateEvents(shows, seating);
        System.out.println("== Generated events:\n" + events.stream()
                .map(Event::getEventInfo).collect(Collectors.joining("\n")));


        Event eventA = events.get(0);
        Event eventB = events.get(1);

        TicketBooker booker = new TicketBookerImpl();
        booker.book(eventA.getSeating(),10);
        booker.book(eventA.getSeating(),15);
        booker.book(eventA.getSeating(),100);

        booker.book(eventB.getSeating(),30);
        booker.book(eventB.getSeating(),25);
        booker.book(eventB.getSeating(),100);

    }


    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the InterruptedException if necessary
            e.printStackTrace();
        }
    }
}
