package ryhor.mudrahel.snva.bootcamp.traffilight;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

        List<String> list = new LinkedList();

        list.add("something");
    }
}
