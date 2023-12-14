package ryhor.mudrahel.snva.bootcamp.bakery;

import ryhor.mudrahel.snva.bootcamp.bakery.pastries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BakeryOperation {

    public static void main(String[] args) {

        int[] pastries = acquireOrder();

        List<Pastry> order = fillPastries(pastries);

        printRecipe(order);

    }

    private static int[] acquireOrder() {
        String[] pastries = new String[4];
        pastries[0] = "Enter no of Black current: ";
        pastries[1] = "Enter no of White Forest: ";
        pastries[2] = "Enter no of Chocolate: ";
        pastries[3] = "Enter no of Red Velvet: ";
        int[] numbers = new int[4];
        int count = 0;

        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        while (count < 4) {
            System.out.print(pastries[count]);

            if (scanner.hasNextInt()) {
                numbers[count] = scanner.nextInt();
                if (numbers[count] > 0) {
                    count++;
                } else {
                    System.out.println("Error: Amount of pastry must be greater than 0.");
                }
            } else {
                System.out.println("Error: Incorrect input. Please enter a valid number of pastry.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        // Closing the Scanner to prevent resource leak
        scanner.close();

        return numbers;
    }

    public static void printRecipe(List<Pastry> order) {
        System.out.println("===================================================================");
        System.out.println("Menu Item          Price                Qty              Payable");
        System.out.println("===================================================================");
        System.out.println(order.get(0).getName() + "      " + order.get(0).getPrice() + "                  "
                + order.get(0).getCount() + "                " + order.get(0).getTotal());
        System.out.println(order.get(1).getName() + "       " + order.get(1).getPrice() + "                  "
                + order.get(1).getCount() + "                " + order.get(1).getTotal());
        System.out.println(order.get(2).getName() + "          " + order.get(2).getPrice() + "                  "
                + order.get(2).getCount() + "                " + order.get(2).getTotal());
        System.out.println(order.get(3).getName() + "         " + order.get(3).getPrice() + "                  "
                + order.get(3).getCount() + "                " + order.get(3).getTotal());
        System.out.println("===================================================================");
        System.out.println("Total                                                    " + calculateTotal(order));
        System.out.println("===================================================================");

    }

    private static double calculateTotal(List<Pastry> pastries) {
        return pastries.stream()
                .mapToDouble(Pastry::getTotal)
                .sum();
    }

    private static List<Pastry> fillPastries(int[] pastries) {
        List<Pastry> order = new ArrayList<>();

        order.add(new BlackCurrent(pastries[0]));
        order.add(new WhiteForest(pastries[1]));
        order.add(new Chocolate(pastries[2]));
        order.add(new RedVelvet(pastries[3]));

        return order;
    }
}