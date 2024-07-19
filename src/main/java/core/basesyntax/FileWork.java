package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        StringBuilder outputBuilder = new StringBuilder();
        Path filePath = Path.of(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String readValue = reader.readLine();
            if (readValue != null) {
                while (readValue != null) {
                    builder.append(readValue).append(" ");
                    readValue = reader.readLine();
                }
                String fullString = builder.toString();
                String[] splitedString = fullString.split(" ");
                for (String words : splitedString) {
                    String lowerCase = words.toLowerCase();
                    char[] splitWords = lowerCase.toCharArray();
                    if (splitWords[0] == 'w') {
                        outputBuilder.append(punctuationCheck(lowerCase));
                    }
                }
                if (!outputBuilder.isEmpty()) {
                    String builderToString = outputBuilder.toString();
                    String[] splitWWords = builderToString.split(" ");
                    Arrays.sort(splitWWords);
                    return splitWWords;
                }
                return new String[]{};
            }
            return new String[]{};
        } catch (IOException e) {
            throw new RuntimeException("can't read a file", e);
        }

    }

    public String punctuationCheck(String stringvalue) {
        char[] splitWords = stringvalue.toCharArray();
        if (!stringvalue.matches("\\w+")) {
            splitWords[splitWords.length - 1] = ' ';
            return String.valueOf(splitWords);
        }
        return stringvalue + " ";
    }
}


