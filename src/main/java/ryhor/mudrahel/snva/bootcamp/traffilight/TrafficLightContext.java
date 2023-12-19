package ryhor.mudrahel.snva.bootcamp.traffilight;

// Context class representing the traffic light
public class TrafficLightContext {
    private TrafficLight trafficLight;

    public TrafficLightContext() {
    }

    public TrafficLightContext(TrafficLight light) {
        this.trafficLight = light;
    }

    public void setState(TrafficLight light) {
        this.trafficLight = light;
    }

    public void requestStateChange() {
        trafficLight.printState(); // Print the current state after the transition
        trafficLight.handleRequest();
    }
}