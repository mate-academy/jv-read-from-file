package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {

        File file = new File(fileName);
        String fileString;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            StringBuilder builder = new StringBuilder();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
            fileString = builder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        fileString = fileString.replaceAll("[^\\w\\s]", "");

        ArrayList<String> words = new ArrayList<>();
        String regex = "\\bw\\w*";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileString);

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            words.add(word);
        }

        Collections.sort(words);

        return words.toArray(new String[0]);
    }
}
