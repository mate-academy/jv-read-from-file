package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        if (file.length() == 0) {
            return new String[]{};
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant' open file named: " + fileName, e);
        }
        String[] splitWords = builder.toString().split("\\W+");
        builder.setLength(0);
        for (String currentWord : splitWords) {
            if (currentWord.toLowerCase().charAt(0) == SPECIFIED_CHARACTER) {
                builder.append(currentWord.toLowerCase()).append(" ");
            }
        }
        if (builder.toString().isEmpty()) {
            return new String[]{};
        }
        String[] specifiedCharacterWords = builder.toString().split(" ");
        Arrays.sort(specifiedCharacterWords);
        return specifiedCharacterWords;
    }
}
