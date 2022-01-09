package fileio.input;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Class which retrieves data from the given input file
 */
public final class InputLoader {
    /**
     * The path to the input file
     */
    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * Read the data from the given input path using Object Mapper
     * @return the read data
     */
    public SimulationDataInput readDataInput() {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(Paths.get(inputPath).toFile(), SimulationDataInput.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
