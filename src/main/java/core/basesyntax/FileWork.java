package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File textFile = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(textFile));
            String textLine = bufferedReader.readLine();

            while (textLine != null) {
                String[] textLineArray = textLine.toLowerCase()
                        .replaceAll("[^a-z]", " ").split(" ");
                for (String word : textLineArray) {
                    if (!word.isEmpty() && word.charAt(0) == 'w') {
                        stringBuilder.append(word).append(" ");
                    }
                }
                textLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File does not exist");
        }
        if (stringBuilder.isEmpty()) {
            return new String[0];
        }

        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
