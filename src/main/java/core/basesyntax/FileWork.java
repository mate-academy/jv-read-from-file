package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader)) {
            String readValue = bufferedReader.readLine();
            if (readValue == null) {
                return new String[]{};
            }
            while (readValue != null) {
                sb.append(readValue).append(" ");
                readValue = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error while reading a file");
        }

        String extractedText = sb.toString();
        Pattern pattern = Pattern.compile("\\bw\\w+");
        Matcher matcher = pattern.matcher(extractedText.toLowerCase().trim());
        sb.setLength(0);

        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }

        String[] split = new String[]{};
        if (sb.length() != 0) {
            split = sb.toString().trim().split(" ");
            Arrays.sort(split);
        }

        return split;
    }
}
