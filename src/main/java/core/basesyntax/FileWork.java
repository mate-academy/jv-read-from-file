package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> listOfWord;
        try {
            listOfWord = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file!", e);
        }
        if (listOfWord.isEmpty()) {
            return new String[]{};
        }
        String [] splitWordFromList = listOfWord.toString().toLowerCase().split("\\W+");
        StringBuilder wordWhichStartFromW = new StringBuilder();
        for (String s : splitWordFromList) {
            if (s.length() == 0) {
                continue;
            }
            if (s.charAt(0) == 'w') {
                wordWhichStartFromW.append(s).append(" ");
            }
        }
        if (wordWhichStartFromW.length() == 0) {
            return new String[]{};
        }
        String [] result = wordWhichStartFromW.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
