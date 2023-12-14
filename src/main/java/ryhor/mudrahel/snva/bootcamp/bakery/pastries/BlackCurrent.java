package ryhor.mudrahel.snva.bootcamp.bakery.pastries;

public class BlackCurrent extends Pastry{
    private final String name="Black Current";
    private final double price=5.0;
    private int count=0;

    public BlackCurrent() {
    }

    public BlackCurrent(int count) {
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
