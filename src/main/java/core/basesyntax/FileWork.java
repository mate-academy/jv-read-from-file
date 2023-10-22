package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
            reader.close();

            String text = content.toString().toLowerCase();

            Pattern pattern = Pattern.compile("\\b\\w+\\b");
            Matcher matcher = pattern.matcher(text);

            HashSet<String> filteredWords = new HashSet<>();
            while (matcher.find()) {
                String word = matcher.group();
                if (word.startsWith("w")) {
                    filteredWords.add(word);
                }
            }
            ArrayList<String> sortedWords = new ArrayList<>(filteredWords);
            Collections.sort(sortedWords, Collator.getInstance());

        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
        return new String[0];
    }
}
