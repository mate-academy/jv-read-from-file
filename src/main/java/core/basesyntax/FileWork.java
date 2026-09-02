package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int INDEX_OF_FIRST_CHAR = 0;
    private static final int STARTING_INDEX = 0;

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String[] wordsStartingWithW;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] words = stringBuilder.toString().split("\\W+");

            int counter = 0;
            for (String word : words) {
                if (!word.isEmpty() && (word.charAt(0) == 'w' || word.charAt(0) == 'W')) {
                    counter++;
                }
            }
            wordsStartingWithW = new String[counter];

            int index = STARTING_INDEX;
            for (String word : words) {
                if (!word.isEmpty() && (word.charAt(INDEX_OF_FIRST_CHAR) == 'w'
                        || word.charAt(0) == 'W')) {
                    wordsStartingWithW[index] = word.toLowerCase();
                    index++;
                }
            }

            Arrays.sort(wordsStartingWithW);

        } catch (IOException e) {
            throw new RuntimeException("Error" + e.getMessage(), e);
        }

        return wordsStartingWithW;
    }
}
