package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder justText = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String string = bufferedReader.readLine();
            while (string != null) {
                justText.append(string).append(" ");
                string = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("There is an exception in try block " + e);
        }
        if (justText.toString().equals("")) {
            return new String[]{};
        }
        String[] dividedWords = justText.toString().toLowerCase()
                .replaceAll("\\p{P}", "").split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : dividedWords) {
            if (word.charAt(0) == 'w') {
                result.append(word).append(" ");
            }
        }
        if (result.toString().equals("")) {
            return new String[]{};
        }
        String[] rightSequenceText = result.toString().split(" ");
        Arrays.sort(rightSequenceText);
        return rightSequenceText;
    }
}

