package ryhor.mudrahel.snva.bootcamp.chatbot.entity;

import ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars.Car;

public class Order {

    private String orderType;
    private String appointment;
    private Car car;
    private double total;
    private double taxes;
    private String paymentType;

    public Order() {
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderType='" + orderType + '\'' +
                ", appointment='" + appointment + '\'' +
                ", car=" + car +
                ", taxes=" + taxes +
                ", total=" + total +
                ", payment type=" + paymentType +
                '}';
    }
}
