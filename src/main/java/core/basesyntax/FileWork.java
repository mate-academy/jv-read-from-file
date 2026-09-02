package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> filteredWords = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.length() < 10 && line.toLowerCase().startsWith("w")) {
                    filteredWords.add(line.toLowerCase());
                } else {
                    Pattern pattern = Pattern.compile("\\b[wW]\\w*\\b");
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String word = matcher.group();
                        filteredWords.add(word.toLowerCase());
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName, e);
        }
        String[] answer = filteredWords.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}
