package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String mainLetter = "w";
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String stringLine = bufferedReader.readLine();
            if (stringLine == null) {
                return new String[0];
            }
            while (stringLine != null) {
                stringBuilder.append(stringLine).append(" ");
                stringLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String[] allWords = stringBuilder.toString().split("\\W+");
        stringBuilder.setLength(0);
        for (String word : allWords) {
            if (word.toLowerCase().split("")[0].equals(mainLetter)) {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        String[] wordsInNatureOrder = stringBuilder.toString().split(" ");
        Arrays.sort(wordsInNatureOrder, Comparator.naturalOrder());
        return wordsInNatureOrder.length > 1 ? wordsInNatureOrder : new String[0];
    }
}
