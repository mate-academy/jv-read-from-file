package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String fileContent = stringBuilder.toString();
            String newFileName = fileContent.replaceAll("([.,;:`!?])", "")
                    .toLowerCase();
            String[] words = newFileName.split(" ");
            int resultLines = 0;
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    resultLines++;
                }
            }
            String[] result = new String[resultLines];
            int counter = 0;
            for (String word : words) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    result[counter] = word;
                    counter++;
                }
            }
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }
}
