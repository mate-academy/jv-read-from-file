package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            List<String> words = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\b\\w+\\b");
                Matcher matcher = pattern.matcher(line.toLowerCase());

                while (matcher.find()) {
                    String word = matcher.group();
                    if (word.startsWith("w")) {
                        words.add(word);
                    }
                }
            }

            reader.close();

            // Sort the filtered words naturally
            Collections.sort(words);

            return words.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
