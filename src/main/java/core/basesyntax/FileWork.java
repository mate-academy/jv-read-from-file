package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String[] result = null;
        int countLengthArray = 0;

        if (file == null) {
            return result;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                String [] substring = value.split(" ");
                for (int i = 0; i < substring.length; i++) {
                    if (substring[i].startsWith("w") || substring[i].startsWith("W")) {
                        if (substring[i].endsWith("!") || substring[i].endsWith("?")
                                || substring[i].endsWith(",") || substring[i].endsWith(".")) {
                            substring[i] = substring[i].substring(0, substring[i].length() - 1);
                        }
                        builder.append(substring[i].toLowerCase(Locale.ROOT)).append(" ");
                        countLengthArray++;
                    }
                }
                value = reader.readLine();
            }
            result = new String[countLengthArray];
            for (int i = 0; i <= result.length - 1; i++) {
                result = builder.toString().split(" ");
                Arrays.sort(result);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return result;
    }
}
