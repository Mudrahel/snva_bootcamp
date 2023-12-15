package ryhor.mudrahel.snva.bootcamp.chatbot.entity.payments;

public class Finance implements Payment {
    private double downPayment;
    private double loan;
    private double interestRate = 0.08;
    private int months;
    private double monthlyPayment;

    public Finance() {
    }

    public Finance(double downPayment, double loan, double interest, int months, double monthlyPayment) {
        this.downPayment = downPayment;
        this.loan = loan;
        this.interestRate = interest;
        this.months = months;
        this.monthlyPayment = monthlyPayment;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
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
        return "Finance";
    }

    @Override
    public String getPaymentData() {
        return "Down payment $"+downPayment+" and monthly payments of $" + monthlyPayment + " for " + months + " months";
    }

}
