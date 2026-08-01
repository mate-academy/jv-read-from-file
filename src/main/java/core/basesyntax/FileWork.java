package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder string = new StringBuilder();
            String value = bufferedReader.readLine();
            if (value != null) {
                while (value != null) {
                    string.append(value).append(System.lineSeparator());
                    value = bufferedReader.readLine();
                }
                String[] newWords = checkWords(string.toString());
                Arrays.sort(newWords);
                return newWords;
            } else {
                return new String[0];
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't read file" + e);
        }
    }

    public String[] checkWords(String sentence) {
        int num = 0;
        String[] words = sentence.split("[\\p{Punct}\\s]+");
        for (String word :
                words) {
            if (word.toLowerCase().startsWith("w")) { // Перевірити, чи починається слово на 'w'
                num++;
            }
        }
        String[] worldsWithW = new String[num];
        num = 0;
        for (String word :
                words) {
            if (word.toLowerCase().startsWith("w")) { // Перевірити, чи починається слово на 'w'
                worldsWithW[num] = word.toLowerCase();
                num++;
            }
        }
        return worldsWithW;
    }
}
