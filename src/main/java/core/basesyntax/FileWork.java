package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String PUNCTUATION_REGEX = "[,.';:?!\"]";
    private static final String ERROR_MSG = "Couldn't read from file";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine().trim();
            while (line != null) {
                String[] words = line.toLowerCase().replaceAll(PUNCTUATION_REGEX, "").split(" ");
                for (String word : words) {
                    if (word.startsWith(SPECIFIED_CHARACTER)) {
                        builder.append(word).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println(ERROR_MSG);
        }

        String finalStr = builder.toString();
        if (finalStr.isEmpty()) {
            return new String[0];
        }
        String[] result = finalStr.split(" ");
        Arrays.sort(result);

        return result;
    }
}
