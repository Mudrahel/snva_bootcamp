package ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars;

public class BMWX3 implements Car {

    private final String model = "X3";
    private int year = 2021;
    private double price = 59000.0;

    public BMWX3() {
    }

    public BMWX3(int year, double price) {
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
        return "BMWX3{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
