package ryhor.mudrahel.snva.bootcamp.chatbot.utility;

public interface TaxCalculator {
    public static final double tax = 0.05;

    public static double calculateTaxes(double price) {
        return price * tax;
    }

}
