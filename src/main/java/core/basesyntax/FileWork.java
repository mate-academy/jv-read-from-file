package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public static final String NO_ANY_WORDS = "";
    public static final String SPLITTER = "\\W+";
    public static final String SPACE_SPLITTER = " ";
    public static final String DESIRED_LETTER = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        String[] arrayOfwords;
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                arrayOfwords = value.split(SPLITTER);
                for (String word : arrayOfwords) {
                    if (String.valueOf(word.charAt(0)).toLowerCase(Locale.ROOT)
                            .equals(DESIRED_LETTER)) {
                        builder.append(word).append(SPACE_SPLITTER);
                    }
                }
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can’t read file", e);
        }
        if (builder.toString().equals(NO_ANY_WORDS)) {
            return new String[] {};
        }
        Arrays.sort(result = builder.toString().toLowerCase(Locale.ROOT).split(SPACE_SPLITTER));
        return result;
    }
}



