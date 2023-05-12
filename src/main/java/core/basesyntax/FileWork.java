package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File myFile = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(myFile))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    String wordLower = word.toLowerCase();
                    if (wordLower.charAt(0) == 'w') {
                        if (wordLower.length() != 1) {
                            builder.append(wordLower).append(" ");
                        }
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file.", e);
        }

        String finishString = builder.toString();

        if (finishString.length() == 0) {
            return new String[0];
        }

        String[] wordsWithW = finishString.split(" ");
        Arrays.sort(wordsWithW);

        return wordsWithW;
    }
}
