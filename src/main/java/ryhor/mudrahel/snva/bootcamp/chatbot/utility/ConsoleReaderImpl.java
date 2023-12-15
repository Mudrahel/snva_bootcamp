package ryhor.mudrahel.snva.bootcamp.chatbot.utility;

import java.util.Scanner;

public class ConsoleReaderImpl implements ConsoleReader {
    private Scanner scanner;

    public ConsoleReaderImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() throws Exception {
        int round = 0;
        while (round<5){
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Error: Incorrect input. Please enter a valid number.");
                scanner.next();
                round++;
            }
        }

        throw new Exception("User failed to enter valid input");
    }

    @Override
    public String readString() {
        return scanner.next();
    }
}
