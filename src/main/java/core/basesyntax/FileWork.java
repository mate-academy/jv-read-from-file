package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileWork {

    private static final String LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder necessaryWords = new StringBuilder();
        try (Scanner scan = new Scanner(new File(fileName))) {
            if (!scan.hasNext()) {
                return new String[0];
            } else {
                while (scan.hasNext()) {
                    String word = scan.next().toLowerCase();
                    if (word.startsWith(LETTER)) {
                        necessaryWords.append(word.replaceAll("[^a-z]","")).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (necessaryWords.length() <= 0) {
            return new String[0];
        }
        String[] result = necessaryWords.toString().trim().split(" ");
        Arrays.sort(result);
        return result;
    }
}
