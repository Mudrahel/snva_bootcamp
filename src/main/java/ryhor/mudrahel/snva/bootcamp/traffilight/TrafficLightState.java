package ryhor.mudrahel.snva.bootcamp.traffilight;

// Interface representing the states of a traffic light
public interface TrafficLightState {
    void handleRequest();
    void printState();
}
