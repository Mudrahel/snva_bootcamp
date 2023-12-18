package ryhor.mudrahel.snva.bootcamp.traffilight;

// Concrete class representing the "Yellow" state
public class YellowLightState implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Switching to Red");
    }

    @Override
    public void printState() {
        System.out.println("Current state: Yellow");
    }
}