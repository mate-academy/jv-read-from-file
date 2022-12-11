package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char DEFAULT_CHAR = 'W';
    private static final String PATTERN = "[^a-zA-Z]";
    private static final int DEFAULT_CHAR_INDEX = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String text = "";
        StringBuilder stringBuilder = new StringBuilder(text);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (text != null) {
                stringBuilder.append(text).append(" ");
                text = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException("Some error", e);
        }

        String[] splitted = stringBuilder.toString().replaceAll(PATTERN, " ")
                .split(" ");
        StringBuilder stringBuilder1 = new StringBuilder("");
        int i = 0;
        for (String split: splitted) {
            if (split.length() >= 1) {
                if (split.charAt(DEFAULT_CHAR_INDEX) == Character.toLowerCase(DEFAULT_CHAR)
                        || split.charAt(DEFAULT_CHAR_INDEX) == DEFAULT_CHAR) {
                    stringBuilder1.append(split.toLowerCase()).append(" ");
                    i++;
                }
            }
        }
        String[] ourWords = stringBuilder1.toString().trim().split(" ");
        Arrays.sort(ourWords);
        return i < 1 ? new String[0] : ourWords;
    }
}

