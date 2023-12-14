package ryhor.mudrahel.snva.bootcamp.bakery.pastries;

public class Pastry {
    private final String name="pastry";
    private final double price=0.0;
    private int count=0;

    public Pastry() {
    }

    public Pastry(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotal(){
        return  getPrice()*getCount();
    }
}
