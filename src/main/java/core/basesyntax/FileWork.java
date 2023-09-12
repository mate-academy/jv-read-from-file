package core.basesyntax;

import java.io.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class FileWork {
    private static final String SPECIFIC_LETTER = "w";
    public String[] readFromFile(String fileName) {
        //write your code here
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
            throw new RuntimeException("Can't reach the file " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }

        return findWordsStartWithSpecificLetter(fileContent.toString());
    }

    private String[] findWordsStartWithSpecificLetter(String input) {
        return Pattern.compile(SPECIFIC_LETTER + "\\w+" + "|" + SPECIFIC_LETTER.toUpperCase() + "\\w+")
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .map(String::toLowerCase)
                .sorted()
                .toArray(String[]::new);
    }
}
