package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> wordsWithW = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String lineReader = reader.readLine();
            while (lineReader != null) {
                String[] words = lineReader.split("\\s+");
                for (String word : words) {
                    Pattern pattern = Pattern.compile("\\bw\\w*\\b", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.find()) {
                        String filteredWord = word.replaceAll("[^\\w]", "").toLowerCase();
                        wordsWithW.add(filteredWord);
                    }
                }
                lineReader = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        Collections.sort(wordsWithW);

        return wordsWithW.toArray(new String[0]);
    }
}
