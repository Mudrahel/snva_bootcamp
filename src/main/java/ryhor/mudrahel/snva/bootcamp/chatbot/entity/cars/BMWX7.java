package ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars;

public class BMWX7 implements Car {

    private final String model = "X7";
    private int year = 2023;
    private double price = 70000.0;

    public BMWX7() {
    }

    public BMWX7(int year, double price) {
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BMWX7{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
