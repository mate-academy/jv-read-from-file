package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final Pattern WORD_WITH_W_PATTERN = Pattern.compile("\\bw\\w*\\b");

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> listWordsWithW = new ArrayList<>();
        String[] wordsWithW;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }

        Matcher matcher =
                WORD_WITH_W_PATTERN.matcher(stringBuilder.toString().toLowerCase());
        while (matcher.find()) {
            listWordsWithW.add(matcher.group());
        }

        wordsWithW = listWordsWithW.toArray(new String[0]);
        Arrays.sort(wordsWithW);
        return wordsWithW;
    }
}
