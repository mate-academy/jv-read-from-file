package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER = "w";
    private static final String SEPARATOR = " ";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String dataFromFile = bufferedReader.readLine();
            while (dataFromFile != null) {
                builder.append(dataFromFile.toLowerCase()).append(System.lineSeparator());
                dataFromFile = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can not read file" + fileName, e);
        }
        String[] words = builder.toString().split("\\W+");
        builder.setLength(0);
        for (String word : words) {
            if (word.startsWith(FIRST_LETTER)) {
                builder.append(word).append(SEPARATOR);
            }
        }
        String[] sortedResultArray = builder.toString().split(SEPARATOR);
        Arrays.sort(sortedResultArray);
        return builder.toString().length() == 0 ? new String[]{} : sortedResultArray;
    }
}
