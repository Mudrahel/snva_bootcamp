package ryhor.mudrahel.snva.bootcamp.bakery.pastries;

public class Chocolate extends Pastry {
    private String name = "Chocolate";
    private double price = 4.0;
    private int count = 0;

    public Chocolate() {
    }

    public Chocolate(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
