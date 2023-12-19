package ryhor.mudrahel.snva.bootcamp.traffilight;

public class TrafficLightRunner {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext(new RedLight());

        // Initial state is Red
        trafficLight.requestStateChange();

        // Switch to Green
        trafficLight.setState(new GreenLight());
        trafficLight.requestStateChange();

        // Switch to Yellow
        trafficLight.setState(new YellowLight());
        trafficLight.requestStateChange();

        // Back to Red
        trafficLight.setState(new RedLight());
        trafficLight.requestStateChange();
    }
}
