package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            // read the file
            int value = bufferedReader.read();
            StringBuilder builder = new StringBuilder();

            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }

            // convert read file to an array with all words:
            String buildedString = builder.toString().toLowerCase();
            String[] allWordsArray = buildedString.split("\\W+");

            // select the words started with SPECIFIED_CHARACTER
            StringBuilder builderSelected = new StringBuilder();
            int counter = 0;

            for (String currentString : allWordsArray) {
                if (currentString.startsWith(SPECIFIED_CHARACTER)) {
                    builderSelected.append(currentString).append(",");
                    counter++;
                }
            }

            // collect selected words into array
            String wordsStartedSpecifiedCharacter = builderSelected.toString().toLowerCase();
            String[] outputArray = wordsStartedSpecifiedCharacter.split("\\W+");
            Arrays.sort(outputArray);

            if (counter == 0) {
                return new String[0];
            }
            return outputArray;

        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
