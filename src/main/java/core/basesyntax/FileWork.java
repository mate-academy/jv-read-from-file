package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIC_LETTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        StringBuilder fileContent = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String value = bufferedReader.readLine();
            while (value != null) {
                fileContent.append(value).append(" ");
                value = bufferedReader.readLine();
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }

        return findSpecificWords(fileContent.toString());
    }

    private String[] findSpecificWords(String input) {
        return Pattern.compile("\\b"
                        + SPECIFIC_LETTER + "\\w+"
                        + "|"
                        + "\\b"
                        + SPECIFIC_LETTER.toUpperCase() + "\\w+")
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new);
    }
}
