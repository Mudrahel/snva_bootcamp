package ryhor.mudrahel.snva.bootcamp.quizplatform.utility;

import java.util.Scanner;

public class ConsoleReaderImpl implements ConsoleReader {
    private Scanner scanner;

    public ConsoleReaderImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        int round = 0;
        while (round < 3) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Error: Incorrect input. Please enter a valid number.");
                scanner.next();
                round++;
            }
        }
        return -1;
    }

    @Override
    public String readString() {
        return scanner.next();
    }

    @Override
    public String readLine() {
        String line = "";
        while (line.isEmpty()) {
            line = scanner.nextLine();
        }
        return line;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
