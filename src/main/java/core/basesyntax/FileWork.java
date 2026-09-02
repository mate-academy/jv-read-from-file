package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> result = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("[A-Za-z]+");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = wordPattern.matcher(line);
                while (matcher.find()) {
                    String word = matcher.group().toLowerCase();
                    if (word.startsWith("w")) {
                        result.add(word);
                    }
                }
            }
        } catch (IOException e) {
            // якщо файл не знайдено або інша помилка — повертаємо порожній масив
            return new String[0];
        }

        result.sort(String::compareTo);
        return result.toArray(new String[0]);
    }
}
