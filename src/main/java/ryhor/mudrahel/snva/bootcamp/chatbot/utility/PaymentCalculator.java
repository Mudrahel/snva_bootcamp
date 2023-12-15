package ryhor.mudrahel.snva.bootcamp.chatbot.utility;

public interface PaymentCalculator {
    public static final double tax = 0.05;

    public static double calculateTaxes(double price) {
        return price * tax;
    }

    public static double calculateMonthlyPayment(double total, int months){
        return total/months;
    }

}
