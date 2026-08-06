package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value;
            do {
                value = bufferedReader.readLine();

                stringBuilder.append(value).append(System.lineSeparator());
            } while (value != null);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String message = stringBuilder.toString().toLowerCase();
        String[] splitMessage = message.split("\\W+");

        int counter = 0;
        for (String singleWord : splitMessage) {
            if (singleWord.startsWith("w")) {
                counter++;
            }
        }

        int j = 0;
        String[] newSplitMessage = new String[counter];
        for (String s : splitMessage) {
            if (s.startsWith("w")) {
                newSplitMessage[j] = s;
                j++;
            }
        }
        Arrays.sort(newSplitMessage);
        return newSplitMessage;
    }
}
