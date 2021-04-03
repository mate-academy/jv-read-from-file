package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String SPECIAL_CHARACTERS = "[,\\s\\-:\\?]";
    private static final String ONLY_WORD_PATTERN = "[^a-z A-Z]";

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value.toLowerCase()).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        String[] array = stringBuilder.toString().split(SPECIAL_CHARACTERS);
        int k = 0;
        for (String word : array) {
            if (startWithLetter(word)) {
                k++;
            }
        }

        int i = 0;
        String[] startWithW = new String[k];
        for (String word : array) {
            if (startWithLetter(word)) {
                startWithW[i] = getOnlyWord(word);
                i++;
            }
        }

        Arrays.sort(startWithW);
        return startWithW;
    }

    private boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    private static String getOnlyWord(String str) {
        Pattern pattern = Pattern.compile(ONLY_WORD_PATTERN);
        Matcher matcher = pattern.matcher(str);
        return matcher.replaceAll("");
    }
}
