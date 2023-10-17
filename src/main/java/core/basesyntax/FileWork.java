package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_LETTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] dataFromFile = stringBuilder.toString().split("\\W+");
        int wordsCount = 0;
        for (int i = 0; i < dataFromFile.length; i++) {
            dataFromFile[i] = dataFromFile[i].toLowerCase();
            if (dataFromFile[i].length() > 0 && dataFromFile[i].charAt(0) == SPECIFIED_LETTER) {
                wordsCount++;
            }
        }

        String[] result = new String[wordsCount];
        for (int i = 0, j = 0; i < dataFromFile.length; i++) {
            if (dataFromFile[i].length() > 0 && dataFromFile[i].charAt(0) == SPECIFIED_LETTER) {
                result[j] = dataFromFile[i];
                j++;
            }
        }

        Arrays.sort(result);
        return result;

    }
}
