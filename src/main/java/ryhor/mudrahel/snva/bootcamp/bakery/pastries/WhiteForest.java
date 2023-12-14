package ryhor.mudrahel.snva.bootcamp.bakery.pastries;

public class WhiteForest extends Pastry {
    public static String name="White Forest";
    public static double price=3.0;
    private int count = 0;

    public WhiteForest() {
    }

    public WhiteForest(int count) {
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
