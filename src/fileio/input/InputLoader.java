package fileio.input;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;

public final class InputLoader {
    /**
     * The path to the input file
     */
    private String inputPath;

    public InputLoader(String inputPath) {
        this.inputPath = inputPath;
    }

    public SimulationDataInput readDataInput() {
        // create object mapper instance
        ObjectMapper mapper = new ObjectMapper();
        try {
            SimulationDataInput simulationDataInput = mapper.readValue(Paths.get(inputPath).toFile(), SimulationDataInput.class);
            return simulationDataInput;
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
}
