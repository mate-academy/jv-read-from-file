package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String W_LETTER = "w";

    public String[] readFromFile(String fileName) throws RuntimeException {
        List<String> wordsWList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] words = line.toLowerCase()
                        .replaceAll("[^a-z]", " ")
                        .split(" ");
                for (String word : words) {
                    if (word.startsWith(W_LETTER)) {
                        wordsWList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Oops! En error has Occurred!", e);
        }
        String[] answer = wordsWList.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }
}
