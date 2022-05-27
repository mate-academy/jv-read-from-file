package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String dataFromFile;
            while ((dataFromFile = bufferedReader.readLine()) != null) {
                String[] arrayFromData = dataFromFile.toLowerCase().split("\\W");
                for (String wordsFromData : arrayFromData) {
                    if (wordsFromData.startsWith(SPECIFIED_CHARACTER)) {
                        builder.append(wordsFromData.toLowerCase())
                                .append(" ");
                    }
                }
            }
            if (builder.length() == 0) {
                return new String[]{};
            }
            String[] finalArray = builder.toString().trim().split(" ");
            Arrays.sort(finalArray);
            return finalArray;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file!", e);
        }
    }
}
