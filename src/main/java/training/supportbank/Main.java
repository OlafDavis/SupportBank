package training.supportbank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        // Your code here!
        System.out.println("Test!!");
        Stream<String> lines = readFile();
    }

    static Stream<String> readFile()  {
        Stream<String> lines = Stream.empty();
        Path path = Paths.get("Transactions2014.csv");
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    static  transactionFromLine(String line) {

    }

}
