package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder uploadedData = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                uploadedData.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return new FileWork().getFiltredValue(uploadedData);
    }

    private String[] getFiltredValue(StringBuilder data) {
        StringBuilder filteredWords = new StringBuilder();
        if (data.length() > 0) {
            String[] allWordsArray = data.toString().replaceAll("\\p{Punct}", "")
                    .toLowerCase().split(" ");
            for (String word : allWordsArray) {
                if (word.startsWith("w")) {
                    filteredWords.append(word).append(" ");
                }
            }
            String[] finalizedArray = filteredWords.length() > 0
                    ? filteredWords.toString().split("\\s+") : new String[]{};
            Arrays.sort(finalizedArray);
            return finalizedArray;
        }
        return new String[]{};
    }
}
