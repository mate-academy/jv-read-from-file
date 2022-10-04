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
        String[] words = new String[fileName.length()];
        StringBuilder stringBuilder = new StringBuilder(" ");
        File file = new File(fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                stringBuilder.append(readLine).append(System.lineSeparator());
                readLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file", e);
        }
        String readStringBuilder = stringBuilder.toString();
        stringBuilder = new StringBuilder();

        String regex = "\\W[Ww][A-z]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(readStringBuilder);
        String lineSeparator = "";
        while (matcher.find()) {
            String curWord = readStringBuilder.substring(matcher.start(), matcher.end());
            stringBuilder.append(lineSeparator).append(curWord.toLowerCase().trim());
            lineSeparator = System.lineSeparator();
        }
        String result = stringBuilder.toString();
        String[] array = result.isEmpty() ? new String[]{} : result.split(lineSeparator);
        Arrays.sort(array);

        return array;
    }
}
