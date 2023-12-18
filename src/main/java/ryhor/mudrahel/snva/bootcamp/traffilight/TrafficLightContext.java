package ryhor.mudrahel.snva.bootcamp.traffilight;

// Context class representing the traffic light
public class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        // Initial state is Red
        this.currentState = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void requestStateChange() {
        currentState.printState(); // Print the current state after the transition
        currentState.handleRequest();
    }
}