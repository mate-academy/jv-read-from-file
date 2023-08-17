package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {
    private String neededLetter = "w";
    private StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(" ");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("impossible read the file", e);
        }
        String[] allWords = stringBuilder.toString().split("\\W+");
        stringBuilder.setLength(0);
        for (String word : allWords) {
            if (word.toLowerCase().startsWith(neededLetter)) {
                stringBuilder.append(word.toLowerCase()).append(" ");
            }
        }
        String[] wordsInNatureOrder = stringBuilder.toString().split(" ");
        Arrays.sort(wordsInNatureOrder, Comparator.naturalOrder());
        return wordsInNatureOrder.length > 1 ? wordsInNatureOrder : new String[0];
    }
}
