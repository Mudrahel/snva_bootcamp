package ryhor.mudrahel.snva.bootcamp.traffilight;

// Concrete class representing the "Red" state
public class RedLight implements TrafficLight {
    @Override
    public void handleRequest() {
        System.out.println("Switching to Green");
    }

    @Override
    public void printState() {
        System.out.println("Current state: Red");
    }
}