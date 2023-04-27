package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public static String[] readFromFile(String fileName) {
        File file = new File(fileName);
        List<String> listWords = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                if ((value >= 64 && value <= 90) || (value >= 97 && value <= 122)
                        || (value >= 9 && value <= 13) || value == 32) {
                    builder.append((char) value);
                }
                value = reader.read();
            }
            String str = builder.toString().toLowerCase();
            String[] arrWords = str.split(" ");
            for (String word : arrWords) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    listWords.add(word);
                }
            }
            String[] res = listWords.toArray(new String[0]);
            Arrays.sort(res, Comparator.naturalOrder());
            return res;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
