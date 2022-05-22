package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String WORD_IDENTIFIER = "w";

    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder builder = new StringBuilder();
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] rowArray = value.toLowerCase().split("\\W");
                for (String word : rowArray) {
                    if (word.startsWith(WORD_IDENTIFIER)) {
                        builder.append(word.toLowerCase())
                                .append(" ");
                    }
                }
            }
            if (builder.length() == 0) {
                return new String[]{};
            }
            String[] specificWordArray = builder.toString().trim().split(" ");
            Arrays.sort(specificWordArray);
            return specificWordArray;
        } catch (IOException e) {
            throw new RuntimeException("The file is blank!", e);
        }
    }
}
