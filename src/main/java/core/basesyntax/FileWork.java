package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String REGEX = "(?i)\\bw[a-zA-Z]+\\b";

    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Path path = file.toPath();
            String input = Files.readString(path).toLowerCase();
            List<String> matchesList = new ArrayList<String>();
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                matchesList.add(matcher.group());
            }
            int sizeOfNewArray = matchesList.size();
            String[] newArrayOfMatches = new String[sizeOfNewArray];
            matchesList.toArray(newArrayOfMatches);
            for (int i = 0; i < newArrayOfMatches.length - 1; i++) {
                for (int j = i + 1; j < newArrayOfMatches.length; j++) {
                    if (newArrayOfMatches[i].compareTo(newArrayOfMatches[j]) > 0) {
                        String temp = newArrayOfMatches[i];
                        newArrayOfMatches[i] = newArrayOfMatches[j];
                        newArrayOfMatches[j] = temp;
                    }
                }
            }
            return newArrayOfMatches;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
