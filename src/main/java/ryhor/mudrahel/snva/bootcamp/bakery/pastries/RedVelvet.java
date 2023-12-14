package ryhor.mudrahel.snva.bootcamp.bakery.pastries;

public class RedVelvet extends Pastry{
    public static String name="Red Velvet";
    public static double price=4.5;
    private int count = 0;

    public RedVelvet() {
    }

    public RedVelvet(int count) {
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
