package ryhor.mudrahel.snva.bootcamp.bookingsystem.factories;

import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.Show;
import ryhor.mudrahel.snva.bootcamp.bookingsystem.entities.ShowImpl;

import java.util.ArrayList;
import java.util.List;

public class ShowsFactory {

    public static List<Show> generateShows(){
        List shows = new ArrayList();
        shows.add(new ShowImpl("Beauty and Beast"));
        shows.add(new ShowImpl("Cinderella"));

        return shows;
    }
}
