package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    private static final String SPECIAL_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.", e);
        }

        String[] fileArr = stringBuilder.toString().split("[\\p{Punct}\\s]+");
        stringBuilder.setLength(0);

        for (int i = 0; i < fileArr.length; i++) {
            fileArr[i] = fileArr[i].toLowerCase(Locale.ROOT);
            if (startWithLetter(fileArr[i])) {
                stringBuilder.append(fileArr[i]).append(" ");
            }
        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        }

        String[] newArr = stringBuilder.toString().split(" ");
        Arrays.sort(newArr);

        return newArr;
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIAL_CHARACTER);
    }
}
