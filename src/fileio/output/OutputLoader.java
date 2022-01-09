package fileio.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

/**
 * Class which writes the output data into the given output path
 */
public class OutputLoader {
    /**
     * the output path
     */
    private final String outputPath;
    /**
     * the to-be-written data
     */
    private final AllYearsChildrenOutput simulationDataOutput;

    public OutputLoader(final String outputPath,
                        final AllYearsChildrenOutput simulationDataOutput) {
        this.outputPath = outputPath;
        this.simulationDataOutput = simulationDataOutput;
    }

    /**
     * Write the data into the output path using Object Mapper
     */
    public void writeDataOutput() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(new File(outputPath), simulationDataOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
