package ryhor.mudrahel.snva.bootcamp.chatbot;

import ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars.BMWX3;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars.BMWX5;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars.BMWX7;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.cars.Car;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.Customer;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.Order;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.payments.Cash;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.payments.Finance;
import ryhor.mudrahel.snva.bootcamp.chatbot.entity.payments.Lease;
import ryhor.mudrahel.snva.bootcamp.chatbot.utility.*;

public class ChatBot {

    public static String BOT_NAME = "Boty";

    public static void main(String[] args) throws Exception {
        runConversation();
    }

    private static void runConversation() throws Exception {

        ConsoleReader console = new ConsoleReaderImpl();
        Customer customer = new Customer();
        Order order = new Order();

        while (true) {
            System.out.println("Greetings! My name is " + BOT_NAME + ", how can address you?");
            System.out.print("Customer:");
            customer.setName(console.readString());
            System.out.println("\n" + BOT_NAME + ": Nice to meet you " + customer.getName());
            sleep();
            System.out.println("\n" + BOT_NAME + ": How might I help you today?");
            sleep();
            System.out.println("Option 1: you looking for a new car?");
            System.out.println("Option 2: (not available) you want to request a maintenance for your car?");
            System.out.println("Option 3: (not available) you want to make a test drive appointment in one of ours dealerships?");
            sleep();
            System.out.println("\n" + BOT_NAME + ": Please enter number of the option.");

            System.out.print(customer.getName() + ": ");
            int coreOption = console.readInt();
            System.out.println("\n" + BOT_NAME + ": You selected Option:" + coreOption);
            //later replace with while case
            if (coreOption == 1) {
                order.setOrderType("new car");
                sleep();
                System.out.println("\n" + BOT_NAME + ": Fantastic. Before I present you our new cars, I need some information. What is your phone number?");
                System.out.print(customer.getName() + ": ");
                customer.setPhone(console.readString());
                sleep();
                System.out.println("\n" + BOT_NAME + ": Got it. What is your mailing address?");
                System.out.print(customer.getName() + ": ");
                customer.setAddress(console.readLine());
                sleep();
                System.out.println("\n" + BOT_NAME + ": Thank you very much. I am checking the closest dealership for you.");
                sleep();
                System.out.println("\n" + BOT_NAME + ": Looks like the closest on is some street,some city, NY dealership. There we have following models:");
                System.out.println("Option 1: X3");
                System.out.println("Option 2: X5");
                System.out.println("Option 3: X7");
                sleep();
                System.out.println("\n" + BOT_NAME + ": Please enter the option number to get more details.");
                System.out.print(customer.getName() + ": ");

                int carOption = console.readInt();
                Car orderedCar;

                if (carOption == 1) {
                    orderedCar = new BMWX3();
                } else if (carOption == 2) {
                    orderedCar = new BMWX5();
                } else {
                    orderedCar = new BMWX7();
                }

                order.setCar(orderedCar);
                order.setTaxes(PaymentCalculator.calculateTaxes(orderedCar.getPrice()));
                order.setTotal(orderedCar.getPrice() + order.getTaxes());
                sleep();
                System.out.println("\n" + BOT_NAME + ": You selected " + orderedCar.getModel() + ", good choice, here is what I can tell you about it:");

                System.out.println("Model name: " + orderedCar.getModel());
                System.out.println("Year of production: " + orderedCar.getYear());
                System.out.println("Price: $" + orderedCar.getPrice());
                System.out.println("Taxes: $" + order.getTaxes());
                System.out.println("Total: $" + order.getTotal());

                sleep();
                System.out.println("\n" + BOT_NAME + ": You have following payment options:");
                System.out.println("Option 1: Cash");
                System.out.println("Option 2: Lease");
                System.out.println("Option 3: Finance");
                sleep();
                System.out.println("\n" + BOT_NAME + ": Please enter the option number");
                System.out.print(customer.getName() + ": ");
                int paymentOption = console.readInt();

                if (paymentOption == 1) {
                    order.setPaymentType(new Cash());
                    System.out.println("\n" + BOT_NAME + ": You chose Option '" + order.getPaymentType().getType() +
                            "'. You can make payment in full during your visit to dealership.");
                } else if (paymentOption == 2) {
                    Lease payment = new Lease();
                    order.setPaymentType(payment);
                    System.out.println("\n" + BOT_NAME + ": You chose Option '" + payment.getType() +
                            "'. Let me see, what option do we have for you today.");
                    sleep();
                    System.out.println("\n" + BOT_NAME + ": We have following options:");
                    System.out.println("Option 1: 3 years (36 months)");
                    System.out.println("Option 2: 5 years (60 months)");
                    System.out.println("Option 3: 7 years (84 months)");
                    System.out.println("\n" + BOT_NAME + ": Please enter the option number");
                    System.out.print(customer.getName() + ": ");
                    int leaseOption = console.readInt();
                    int leaseMonths;
                    if (leaseOption == 1) {
                        leaseMonths = 36;
                    } else if (leaseOption == 2) {
                        leaseMonths = 60;
                    } else {
                        leaseMonths = 84;
                    }
                    payment.setMonths(leaseMonths);
                    payment.setMonthlyPayment(PaymentCalculator.calculateMonthlyPayment(order.getTotal(), leaseMonths));

                    System.out.println("\n" + BOT_NAME + ": Understood. Your monthly payment will be: $" + payment.getMonthlyPayment());

                } else {
                    Finance payment = new Finance();
                    order.setPaymentType(payment);
                    System.out.println("\n" + BOT_NAME + ": You chose Option '" + order.getPaymentType().getType());
                    sleep();
                    System.out.println("\n" + BOT_NAME + ": Got it. How much out of $" + order.getTotal() + " you can pay as down payment?");
                    System.out.print(customer.getName() + ": ");
                    int downPayment = console.readInt();
                    payment.setDownPayment(downPayment);
                    double remainingPayment = order.getTotal() - downPayment;
                    payment.setLoan(remainingPayment + remainingPayment * payment.getInterestRate());
                    System.out.println("\n" + BOT_NAME + ": With down payment of $" + downPayment
                            + ", remaining payment for the car (based on " + payment.getInterestRate() * 100 + "%) is $"
                            + payment.getLoan() + ". We have following options:");
                    System.out.println("Option 1: 3 years (36 months)");
                    System.out.println("Option 2: 5 years (60 months)");
                    System.out.println("Option 3: 7 years (84 months)");
                    System.out.println("\n" + BOT_NAME + ": Please enter the option number");
                    System.out.print(customer.getName() + ": ");
                    int leaseOption = console.readInt();
                    int leaseMonths;
                    if (leaseOption == 1) {
                        leaseMonths = 36;
                    } else if (leaseOption == 2) {
                        leaseMonths = 60;
                    } else {
                        leaseMonths = 84;
                    }
                    payment.setMonths(leaseMonths);
                    payment.setMonthlyPayment(PaymentCalculator.calculateMonthlyPayment(payment.getLoan(), leaseMonths));

                    System.out.println("\n" + BOT_NAME + ": Understood. Your monthly payment will be: $" + payment.getMonthlyPayment());

                }
                sleep();
                System.out.println("\n" + BOT_NAME + "Let me schedule you an appointment. I have following open windows for you:");
                System.out.println("Option 1: 9am (est). Monday. 18/12/2023");
                System.out.println("Option 2: 11am (est). Tuesday. 19/12/2023");
                System.out.println("Option 3: 2pm (est). Thursday. 21/12/2023");
                sleep();
                System.out.println("\n" + BOT_NAME + ": Please enter the option number");
                System.out.print(customer.getName() + ": ");
                int appointmentOption = console.readInt();

                if (appointmentOption == 1) {
                    order.setAppointment("9am (est). Monday. 18/12/2023");
                } else if (appointmentOption == 2) {
                    order.setAppointment("11am (est). Tuesday. 19/12/2023");
                } else {
                    order.setAppointment("2pm (est). Thursday. 21/12/2023");
                }
                sleep();

                System.out.println("\n" + BOT_NAME + ": got it. I will send you a reminder, a day before the appointment. " +
                        "Meanwhile, please provide an email, where I can send order confirmation.");
                System.out.print(customer.getName() + ": ");
                customer.setEmail(console.readString());

                sleep();
                System.out.println("\n" + BOT_NAME + ": Thank you. Is there anything else I can help you with today? ");
                System.out.println("Option 1: Yes");
                System.out.println("Option 2: No");
                sleep();
                System.out.println("\n" + BOT_NAME + ": Please enter the option number");

                System.out.print(customer.getName() + ": ");
                int continueOption = console.readInt();

                sleep();
                System.out.println("\n" + BOT_NAME + ": it was nice talking to you today " + customer.getName() + ". Have a nice weekend.");

            }

            // Closing the Scanner to prevent resource leak
            console.close();

            break;
        }

        printResult(customer, order);
    }

    private static void printResult(Customer customer, Order order) {
        Printer printer = new PrinterImpl();
        printer.printCustomerData(customer);
        printer.printOrderData(order);
        printer.printPaymentPlan(order.getPaymentType());
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Handle the InterruptedException if necessary
            e.printStackTrace();
        }
    }
}
