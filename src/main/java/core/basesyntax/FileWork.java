package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final int BIG_A_CHARACTER_CODE = 65;
    private static final int BIG_Z_CHARACTER_CODE = 90;
    private static final int SMALL_A_CHARACTER_CODE = 97;
    private static final int SMALL_Z_CHARACTER_CODE = 122;
    private static final int SPACE_CHARACTER_CODE = 32;
    private static final int NEWLINE_CHARACTER_CODE = 10;

    public String[] readFromFile(String fileName) {
        String[] allWords = readAllWordsFromFile(fileName);
        ArrayList<String> wordsStartsWithW = new ArrayList<>();
        for (String word : allWords) {
            String wordInLowerCase = word.toLowerCase();
            if (wordInLowerCase.startsWith("w")) {
                wordsStartsWithW.add(wordInLowerCase);
            }
        }
        Collections.sort(wordsStartsWithW);
        return wordsStartsWithW.toArray(new String[0]);
    }

    private String[] readAllWordsFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            int charCode = bufferedReader.read();
            while (charCode != -1) {
                if (charCode == NEWLINE_CHARACTER_CODE) {
                    charCode = SPACE_CHARACTER_CODE;
                }
                if (charCode >= BIG_A_CHARACTER_CODE && charCode <= BIG_Z_CHARACTER_CODE
                        || charCode >= SMALL_A_CHARACTER_CODE && charCode <= SMALL_Z_CHARACTER_CODE
                        || charCode == SPACE_CHARACTER_CODE) {
                    stringBuilder.append((char) charCode);
                }
                charCode = bufferedReader.read();
            }
        } catch (IOException ioException) {
            throw new RuntimeException("cannot read data from file - " + file);
        }
        return stringBuilder.toString().split(" ");
    }
}
