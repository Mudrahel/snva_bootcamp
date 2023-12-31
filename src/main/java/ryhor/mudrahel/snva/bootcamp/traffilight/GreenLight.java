package ryhor.mudrahel.snva.bootcamp.traffilight;

// Concrete class representing the "Green" state
public class GreenLight implements TrafficLight {
    @Override
    public void handleRequest() {
        System.out.println("Switching to Yellow");
    }

    @Override
    public void printState() {
        System.out.println("Current state: Green");
    }
}