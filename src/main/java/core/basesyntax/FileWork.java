package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    private static final String CHARACTER = "w";
    private static final Pattern PATTERN = Pattern.compile("\\W+");

    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = PATTERN.split(line.toLowerCase().trim());
                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith(CHARACTER)) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }
}
