package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        String readedText = " ";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder builder = new StringBuilder();
            String words = bufferedReader.readLine();
            while (words != null) {
                builder.append(words).append(" ");
                words = bufferedReader.readLine();
            }
            readedText = builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        String[] words = readedText.split("\\W+");
        int count = 0;
        for (String word : words) {
            if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                count++;
            }
        }
        int countIndex = 0;
        String[] arrayToReturn = new String[count];
        for (int i = 0; i < words.length; i++) {
            if (words[i].toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                arrayToReturn[countIndex] = words[i].toLowerCase();
                countIndex++;
            }
        }
        if (arrayToReturn.length == 0) {
            return arrayToReturn;
        }
        Arrays.sort(arrayToReturn);

        return arrayToReturn;
    }
}
