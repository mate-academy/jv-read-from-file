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
        String answerString = "";
        StringBuilder stringBuilder = new StringBuilder(answerString);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                String[] strings = value.split(" ");
                for (String str : strings) {
                    String s = str.toLowerCase(Locale.ROOT).replaceAll(
                            "[.,?!]", "");
                    if (s.startsWith("w")) {
                        stringBuilder.append(s).append(" ");
                    }
                }
                value = reader.readLine();
            }
            answerString = stringBuilder.toString();
            if (answerString.equals("")) {
                return new String[0];
            }
            String[] outputArray = stringBuilder.toString().split(" ");
            Arrays.sort(outputArray);
            return outputArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + fileName, e);
        }
    }
}
