package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String stringRead;
            while ((stringRead = bufferedReader.readLine()) != null) {
                stringBuilder.append(" ").append(stringRead);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] separatedWordArray = stringBuilder.toString().split("[\\s\\p{Punct}]+");
        int countWordsWithW = 0;

        for (String word : separatedWordArray) {
            if (word.startsWith("w") || word.startsWith("W")) {
                countWordsWithW++;
            }
        }

        String[] wordsStartWithW = new String[countWordsWithW];
        int index = 0;

        for (String s : separatedWordArray) {
            if (s.startsWith("w") || s.startsWith("W")) {
                wordsStartWithW[index] = s.toLowerCase();
                index++;
            }
        }
        Arrays.sort(wordsStartWithW);
        return wordsStartWithW;
    }
}
