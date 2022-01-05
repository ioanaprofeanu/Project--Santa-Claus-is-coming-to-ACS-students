package fileio.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class OutputLoader {
    /**
     * the output path
     */
    private String outputPath;
    /**
     * the to-be-written data
     */
    private AllYearsChildrenOutput simulationDataOutput;

    public OutputLoader(String outputPath, AllYearsChildrenOutput simulationDataOutput) {
        this.outputPath = outputPath;
        this.simulationDataOutput = simulationDataOutput;
    }

    public void writeDataOutput() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
            System.out.println(outputPath);
            writer.writeValue(new File(outputPath), simulationDataOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public AllYearsChildrenOutput getSimulationDataOutput() {
        return simulationDataOutput;
    }

    public void setSimulationDataOutput(AllYearsChildrenOutput simulationDataOutput) {
        this.simulationDataOutput = simulationDataOutput;
    }
}
