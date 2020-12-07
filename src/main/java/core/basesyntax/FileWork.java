package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String W_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder wordsReader = new StringBuilder();
            String readLine = reader.readLine();
            int counter = 0;
            while (readLine != null) {
                String[] arrReadLine = readLine.split("\\s*(\\s|,|!|\\.|\\?)\\s*");
                for (int i = 0; i < arrReadLine.length; i++) {
                    if (arrReadLine[i].toLowerCase().startsWith(W_CHARACTER)) {
                        wordsReader.append(arrReadLine[i].toLowerCase()).append(" ");
                    }
                }
                readLine = reader.readLine();
            }
            return createArrayAndSort(wordsReader);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    private String[] createArrayAndSort(StringBuilder wordsReader) {
        if (wordsReader.toString().equals("")) {
            return new String[0];
        }
        String[] arrW = wordsReader.toString().split(" ");
        Arrays.sort(arrW);
        return arrW;
    }
}
