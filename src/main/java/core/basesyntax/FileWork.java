package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char STARTED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String text = bufferedReader.readLine();
            while (text != null) {
                String[] textArray = text.split("\\W+");
                for (String word : textArray) {
                    String lowerWord = word.toLowerCase();
                    if (lowerWord.charAt(0) == STARTED_CHARACTER) {
                        if (lowerWord.length() != -1) {
                            stringBuilder.append(lowerWord).append(" ");
                        }
                    }
                }
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read file.", e);
        }
        String result = stringBuilder.toString();
        if (result.length() == 0) {
            return new String[0];
        }
        String[] withW = result.split(" ");
        Arrays.sort(withW);
        return withW;
    }
}
