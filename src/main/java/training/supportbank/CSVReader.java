package training.supportbank;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CSVReader implements FileReader {
    private String filename;
    private static final Logger LOGGER = LogManager.getLogger();

    public CSVReader(String filename) {
        this.filename = filename;
    }

    public Stream<String> getTextStream() {
        Stream<String> lines = Stream.empty();
        LOGGER.log(Level.INFO,"reading CSV file " + this.filename);
        Path path = Paths.get(this.filename);
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
