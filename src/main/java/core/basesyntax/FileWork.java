package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String[] checkEmpty = new String[0];
        StringBuilder selectedWords = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            Pattern pattern = Pattern.compile("[ ,.!?:;]");

            while (line != null) {
                line = line.toLowerCase();
                String[] arrayOfWordsOfLine = pattern.split(line);
                for (String wordOfLine : arrayOfWordsOfLine) {
                    if (wordOfLine.startsWith("w")) {
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
        return selectedWords.length() != 0 ? arrayOfSelectWords : checkEmpty;
    }
}
