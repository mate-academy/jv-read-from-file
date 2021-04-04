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
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file...");
        }

        int count = 0;
        String[] arrayOfWords = stringBuilder.toString().toLowerCase()
                .replaceAll("[^a-z ^A-Z]", "").split(" ");
        for (String words : arrayOfWords) {
            if (words.startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        if (count == 0) {
            return new String[]{};
        }
        int index = -1;
        String[] stringWithSpecifiedLetter = new String[count];
        for (String word : arrayOfWords) {
            if (word.startsWith(SPECIFIED_CHARACTER)) {
                index++;
                stringWithSpecifiedLetter[index] = word;
            }
        }
        Arrays.sort(stringWithSpecifiedLetter);
        return stringWithSpecifiedLetter;
    }
}
