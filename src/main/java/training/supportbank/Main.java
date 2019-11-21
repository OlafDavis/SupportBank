package training.supportbank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        Account[] accounts = [];
        Stream<Transaction> transactionStream = Stream.empty();
        transactionStream = readFile()
                .skip(1)
                .map(line -> transactionFromLine(line));
        transactionStream.forEach(transaction -> ProcessTransaction(accounts, transaction));
    }

    private static Stream<String> readFile()  {
        Stream<String> lines = Stream.empty();
        Path path = Paths.get("Transactions2014.csv");
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Transaction transactionFromLine(String line) {
        String[] items = line.split(",");
        return new Transaction(items[1],items[2],Integer.getInteger(items[4]));
    }

}
