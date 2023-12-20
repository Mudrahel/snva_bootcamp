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

        Runner.runDemo();

    }

}
