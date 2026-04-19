package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        List<String> searchedWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String input = reader.readLine();
            while (input != null) {
                searchForWordStaringWithW(searchedWords, input);
                input = reader.readLine();
            }
        } catch (IOException ex) {
            throw new RuntimeException("Can't read from file " + fileName, ex);
        }
        String[] result = searchedWords.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }

    private static void searchForWordStaringWithW(List<String> searchedWords, String input) {
        String[] separatedString = input.toLowerCase().split("[^a-zA-Z]");
        for (String word : separatedString) {
            if (word.startsWith("w")) {
                searchedWords.add(word);
            }
        }
    }
}
