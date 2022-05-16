package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadDataFromFile {
    public String readFromFile(String fileName) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader rb = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = rb.readLine()) != null) {
                data.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("Error read data from file %s", fileName), e);
        }

        return data.toString().strip();
    }
}
