package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] words = new String[fileName.length()];
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String a = stringBuilder.toString().toLowerCase();
            String regex = "w[a-z]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(a);
            while (matcher.find()) {
                words = pattern.split(a);
            }

        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file", e);
        }
        return words;
    }
}
