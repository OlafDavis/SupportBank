package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String args[]) {
        LOGGER.log(Level.INFO, "Program started");
        Scanner scanner = new Scanner(System.in);
        AccountsBook accounts = new AccountsBook();
        Stream<Transaction> transactionStream = Stream.empty();
        transactionStream = readFile()
                .skip(1)
                .map(line -> transactionFromLine(line));
        LOGGER.log(Level.INFO,"running ProcessTransaction on stream");
        transactionStream.forEach(transaction -> accounts.ProcessTransaction(transaction));
        String command = "";
        while (!command.equals("exit")) {
            System.out.println("Enter command: \"List All\", \"List [NAME]\", or \"Exit\".");
            command = scanner.nextLine().toLowerCase();
            LOGGER.log(Level.INFO, "command read: " + command);
            if (command.equals("list all")) {accounts.ListAll();}
            else if (command.length() > 5 && command.substring(0,5).equals("list ")) {accounts.ListAccount(command.substring(5,command.length()));}
            else if (!command.equals("exit")) {System.out.println("Unknown command.");}
        }
    }

    private static Stream<String> readFile()  {
        Stream<String> lines = Stream.empty();
        String filename = "Transactions2014.csv";
        LOGGER.log(Level.INFO,"reading file " + filename);
        Path path = Paths.get(filename);
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Transaction transactionFromLine(String line) {
        String[] items = line.split(",");
        Integer amount = Math.round(Float.parseFloat(items[4]) * 100);
        return new Transaction(items[1],items[2], amount);
    }

    public static String FormatAmount(Integer amountPence) {
        String sign = (amountPence < 0) ? "-" : "";
        Integer absPence = Math.abs(amountPence);
        return sign + "£" + absPence / 100 + "." + absPence % 100;
    }

}
