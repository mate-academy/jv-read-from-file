package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    private static final String CHECK_LITERAL = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder selectedWords = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            Pattern pattern = Pattern.compile("[ ,.!?:;]");

            while (line != null) {
                line = line.toLowerCase();
                String[] arrayOfWordsOfLine = pattern.split(line);
                for (String wordOfLine : arrayOfWordsOfLine) {
                    if (wordOfLine.startsWith(CHECK_LITERAL)) {
                        selectedWords.append(wordOfLine).append(" ");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't found the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }

        String[] arrayOfSelectWords = selectedWords.toString().split(" ");
        Arrays.sort(arrayOfSelectWords);
        return selectedWords.length() != 0 ? arrayOfSelectWords : new String[0];
    }
}
