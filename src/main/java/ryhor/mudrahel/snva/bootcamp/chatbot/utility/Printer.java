package ryhor.mudrahel.snva.bootcamp.chatbot.utility;

import ryhor.mudrahel.snva.bootcamp.chatbot.entity.Customer;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.Order;

public interface Printer {
    public void printCustomerData(Customer customer);
    public void printOrderData(Order order);
}
