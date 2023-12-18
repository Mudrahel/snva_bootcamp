package ryhor.mudrahel.snva.bootcamp.traffilight;

public class TrafficLightRunner {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        // Initial state is Red
        trafficLight.requestStateChange();

        // Switch to Green
        trafficLight.setState(new GreenLightState());
        trafficLight.requestStateChange();

        // Switch to Yellow
        trafficLight.setState(new YellowLightState());
        trafficLight.requestStateChange();

        // Back to Red
        trafficLight.setState(new RedLightState());
        trafficLight.requestStateChange();
    }
}
