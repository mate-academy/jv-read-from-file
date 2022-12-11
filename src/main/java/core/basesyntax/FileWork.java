package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder addLineFromFile = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String component = reader.readLine();
            while (component != null) {
                component = component.toLowerCase();
                addLineFromFile.append(component).append(System.lineSeparator());
                component = reader.readLine();
            }
            String[] splitLine = addLineFromFile.toString().split("\\W+");
            StringBuilder wordsW = new StringBuilder();
            for (String enumerationElement : splitLine) {
                if (enumerationElement.startsWith("w")) {
                    wordsW.append(enumerationElement).append(" ");
                }
            }
            splitLine = wordsW.toString().trim().split(" ");
            Arrays.sort(splitLine);
            if (addLineFromFile.length() == 0) {
                return new String[0];
            }
            return splitLine;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
