package ryhor.mudrahel.snva.bootcamp.chatbot.utility;

import ryhor.mudrahel.snva.bootcamp.chatbot.entity.Customer;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.Order;

public class PrinterImpl implements Printer{
    private String delimeter="==================================================";
    private String header="============== %-15s ===================%n";
    private String line="%-20s %-20s %n";
    @Override
    public void printCustomerData(Customer customer) {
        System.out.format(header,"Customer Data");
        System.out.format(line,"name",customer.getName());
        System.out.format(line,"phone",customer.getPhone());
        System.out.format(line,"email",customer.getEmail());
        System.out.format(line,"address",customer.getAddress());
        System.out.println(delimeter);
    }

    @Override
    public void printOrderData(Order order) {
        System.out.format(header,"Order data");
        System.out.format(line,"order type",order.getOrderType());
        System.out.format(line,"Appointment",order.getAppointment());
        System.out.format(line,"Car model",order.getCar().getModel());
        System.out.format(line,"Car year",order.getCar().getYear());
        System.out.format(line,"price",order.getCar().getPrice());
        System.out.format(line,"taxes",order.getTaxes());
        System.out.format(line,"total",order.getTotal());
        System.out.format(line,"selected payment",order.getPaymentType());
        System.out.println(delimeter);

    }
}
