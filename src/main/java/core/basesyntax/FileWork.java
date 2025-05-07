package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] emptyArray = new String[0];
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            if (value == null) {
                return emptyArray;
            }
            while (value != null) {
                builder.append(value).append(" ");
                value = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }

        int counterForW = 0;
        String allWords = builder.toString().toLowerCase();
        String[] allWordsInLowerCase = allWords.split("\\W+");
        for (String nameForCount : allWordsInLowerCase) {
            if (nameForCount.charAt(0) == 'w') {
                counterForW++;
            }
        }

        String[] result = new String[counterForW];
        int newCounter = 0;
        for (String nameForArray : allWordsInLowerCase) {
            if (nameForArray.charAt(0) == 'w') {
                result[newCounter] = nameForArray;
                newCounter++;
            }
        }

        Arrays.sort(result);
        return result;
    }
}
