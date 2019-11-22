package training.supportbank;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.stream.Stream;

public class JSONReader implements FileReader {
    private String filename;
    private GsonBuilder gsonBuilder;
    private static final Logger LOGGER = LogManager.getLogger();

    public JSONReader(String filename) {
        this.filename = filename;
        GsonBuilder gsonBuilder = new GsonBuilder();
    }

    public Stream<String> getTextString() {
        this.gsonBuilder.registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) ->
                // Convert jsonElement to a LocalDate here...
        );
        Gson gson = gsonBuilder.create();
    }

}