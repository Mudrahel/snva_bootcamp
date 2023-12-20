package ryhor.mudrahel.snva.bootcamp.bookingsystem.entities;

public class ShowImpl implements Show{
    private String title;

    public ShowImpl(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}

