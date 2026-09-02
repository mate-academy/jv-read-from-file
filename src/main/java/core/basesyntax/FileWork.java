package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String LINE_SEPARATOR = " ";
    public static final String SPLITTER = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringFile = new StringBuilder();
        StringBuilder resultingArrayBuilder = new StringBuilder();

        if (file.length() == 0) {
            return new String[0];
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                stringFile.append(value).append(LINE_SEPARATOR);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't save content");
        }

        String fileContent = stringFile.toString().toLowerCase();
        String[] words = fileContent.split("\\W+");
        Arrays.sort(words);

        for (String word : words) {
            if (word.startsWith("w")) {
                resultingArrayBuilder.append(word).append(" ");
            }
        }
        if (!resultingArrayBuilder.toString().contains("w")) {
            return new String[0];
        }
        return resultingArrayBuilder.toString().trim().split(SPLITTER);
    }
}
