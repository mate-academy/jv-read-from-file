package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String[] sortArrayWithOnlyW = new String[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder reader = new StringBuilder();
            String value = bufferedReader.readLine();
            String textFromFile = null;
            while (value != null) {
                reader.append(value).append(" ");
                value = bufferedReader.readLine();
                textFromFile = reader.toString();
            }
            String[] arrayWithoutPunctuationInLowerCase = new String[0];
            if (textFromFile != null) {
                arrayWithoutPunctuationInLowerCase = textFromFile
                        .replaceAll("[?.!,-]", "")
                        .toLowerCase()
                        .split(" ");
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : arrayWithoutPunctuationInLowerCase) {
                if (string.startsWith(SPECIFIED_CHARACTER)) {
                    stringBuilder.append(" ").append(string);
                }
            }
            String stringWithWordsW = stringBuilder.toString();
            if (!stringWithWordsW.isEmpty()) {
                sortArrayWithOnlyW = stringWithWordsW.strip().split(" ");
                Arrays.sort(sortArrayWithOnlyW);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
        return sortArrayWithOnlyW;
    }
}
