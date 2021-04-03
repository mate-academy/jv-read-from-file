package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char GIVEN_CHARACTER = 'w';
    public static final String WHITE_SPACE = " ";
    public static final String EMPTY = "";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String newString = EMPTY;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(WHITE_SPACE);
                line = reader.readLine();
                for (String word : words) {
                    if (word.toLowerCase().charAt(0) == GIVEN_CHARACTER) {
                        newString += word.toLowerCase().replaceAll("\\p{P}", EMPTY)
                                + WHITE_SPACE;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        if (newString.equals(EMPTY)) {
            String[] emptyArray = new String[0];
            return emptyArray;
        }
        String[] answer = newString.split(WHITE_SPACE);
        Arrays.sort(answer);
        return answer;
    }
}
