package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        String[] result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String stringInFile = stringBuilder.toString();
            String[] parts = stringInFile.split("\\W+");
            int count = 0;
            Pattern pattern = Pattern.compile("^[Ww]\\w*");
            for (String word : parts) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()) {
                    count++;
                }
            }
            result = new String[count];
            int index = 0;
            for (String entry : parts) {
                Matcher matcher2 = pattern.matcher(entry);
                if (matcher2.find()) {
                    result[index] = entry.toLowerCase();
                    index++;
                }
            }
            Arrays.sort(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
