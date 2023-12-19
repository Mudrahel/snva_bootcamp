package ryhor.mudrahel.snva.bootcamp.traffilight;



public interface TrafficLight extends TrafficLightState,TrafficRequestHandler{
    void printState();
    void handleRequest();
}
