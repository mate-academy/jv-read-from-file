package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder readValue = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int value = bufferedReader.read();
            while (value != -1) {
                readValue.append((char) value);
                value = bufferedReader.read();
            }
            String[] lineFromFileName = readValue.toString().split("[\\W\\s]");
            for (String file : lineFromFileName) {
                if (file.startsWith(SPECIFIED_CHARACTER)
                        || file.startsWith(SPECIFIED_CHARACTER.toUpperCase())) {
                    stringBuilder.append(file.toLowerCase()).append(" ");
                }
            }
            if (stringBuilder.toString().isEmpty()) {
                return new String[]{};
            }
            String[] lineWithoutW = stringBuilder.toString().split("[\\W\\s]");
            Arrays.sort(lineWithoutW);
            return lineWithoutW;

        } catch (IOException ex) {
            System.out.println("Exception");
        }
        return null;
    }
}
