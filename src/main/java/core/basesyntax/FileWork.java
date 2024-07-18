package core.basesyntax;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    private static final String CHARACTER = "w";
    private static final Pattern PATTERN = Pattern.compile("\\W+");
    private static final List<String> RESULT = new ArrayList<>();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            return null;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = PATTERN.split(line.toLowerCase());
                for (String word : words) {
                    if (word.startsWith(CHARACTER)) {
                        RESULT.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return RESULT.toArray(new String[0]);
    }
}
