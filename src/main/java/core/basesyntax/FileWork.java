package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder words = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                Matcher matcher = Pattern.compile("\\b[w][a-z]*").matcher(line.toLowerCase());
                while (matcher.find()) {
                    words.append(matcher.group()).append(" ");
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = words.toString().trim();
        if (result.isEmpty()) {
            return new String[]{};
        }
        String[] resultArray = result.split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
