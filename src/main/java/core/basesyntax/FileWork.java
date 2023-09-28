package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            int totalArrayLength = 0;
            List<String> sentences = Files.readAllLines(file.toPath());

            for (String sentence : sentences) {
                String[] sentenceInWords = sentence.toLowerCase().split("\\W+");
                for (String word : sentenceInWords) {
                    if (word.toCharArray()[0] == SPECIFIED_CHARACTER) {
                        totalArrayLength++;
                    }
                }
            }

            String[] result = new String[totalArrayLength];
            int index = 0;

            for (String sentence : sentences) {
                String[] sentenceInWords = sentence.toLowerCase().split("\\W+");
                for (String word : sentenceInWords) {
                    if (word.toCharArray()[0] == SPECIFIED_CHARACTER) {
                        result[index] = word;
                        index++;
                    }
                }
            }
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
