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
        StringBuilder stringBuilder = new StringBuilder(" ");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readedLine = bufferedReader.readLine();
            while (readedLine != null) {
                stringBuilder.append(readedLine).append(System.lineSeparator());
                readedLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        String readedContent = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\W[Ww][A-z]*");
        Matcher matcher = pattern.matcher(readedContent);
        String lineSeparator = "";
        while (matcher.find()) {
            String curWord = readedContent.substring(matcher.start(), matcher.end());
            stringBuilder.append(lineSeparator).append(curWord.toLowerCase().trim());
            lineSeparator = System.lineSeparator();
        }
        String resString = stringBuilder.toString();
        String[] matcherArray = resString.isEmpty()
                ? new String[] {} : resString.split(lineSeparator);
        Arrays.sort(matcherArray);
        return matcherArray;
    }
}
