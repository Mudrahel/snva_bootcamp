package ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars;

public class BMWX5 implements Car {

    private final String model = "X5";
    private int year = 2022;
    private double price = 65500.0;

    public BMWX5() {
    }

    public BMWX5(int year, double price) {
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
        return "BMWX5{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
