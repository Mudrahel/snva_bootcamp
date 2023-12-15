package ryhor.mudrahel.snva.bootcamp.chatbot.entity.payments;

public class Lease implements Payment {
    private int months;
    private double monthlyPayment;

    public Lease() {
    }

    public Lease(int months, double monthlyPayment) {
        this.months = months;
        this.monthlyPayment = monthlyPayment;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getType() {
        return "Lease";
    }

    @Override
    public String getPaymentData() {
        return "Monthly payments of $" + monthlyPayment + " for " + months + " months";
    }


}
