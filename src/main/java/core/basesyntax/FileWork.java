package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static char CHECKED_LATTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder fullText = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String readLine;
            while ((readLine = br.readLine()) != null) {
                fullText.append(readLine);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String[] result = fullText
                .toString()
                .toLowerCase()
                .replaceAll("[^A-Za-zА-Яа-я ]", "")
                .split(" ");
        return fullText.length() == 0 ? new String[0] : Arrays
                .stream(result)
                .filter(word -> word.charAt(0) == CHECKED_LATTER)
                .sorted()
                .toArray(String[]::new);
    }
}
