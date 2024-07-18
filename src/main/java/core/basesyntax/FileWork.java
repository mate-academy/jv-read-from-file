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
    private static final List<String> RESULT = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = PATTERN.split(line.toLowerCase().trim());
                for (String word : words) {
                    if (!word.isEmpty() && word.startsWith(CHARACTER)) {
                        RESULT.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(RESULT);
        return RESULT.toArray(new String[0]);
    }
}
