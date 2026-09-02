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
        String newString = getString(fileName);
        int counter = 0;
        Pattern p = Pattern.compile("\\b[Ww]\\w*\\b(?=\\D)");
        Matcher m = p.matcher(newString);
        StringBuilder tempString = new StringBuilder();
        while (m.find()) {
            tempString.append(m.group()).append(System.lineSeparator());
            counter++;
        }
        if (counter == 0) {
            return new String[]{};
        } else {
            String[] separatedArray = tempString.toString()
                    .toLowerCase()
                    .split(System.lineSeparator());
            Arrays.sort(separatedArray);
            return separatedArray;
        }
    }

    private static String getString(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                stringBuilder.append((char) symbol);
                symbol = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file" + e);
        }
        return stringBuilder.toString();
    }
}
