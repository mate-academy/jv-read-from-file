package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        StringBuilder resultString = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();

            while (line != null) {
                String[] words = words(line);
                for (String word : words) {
                    if (word.charAt(0) == 'w') {
                        resultString.append(word).append(" ");
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] resultArray = resultString.toString().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }

    private static String[] words(String line) {
        return line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }
}
