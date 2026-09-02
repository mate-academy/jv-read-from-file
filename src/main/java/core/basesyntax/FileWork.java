package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        final int arrSize = getSizeForArray(fileName);
        String[] wordsWithW = new String[arrSize];

        if (arrSize == 0) {
            return wordsWithW;
        }

        List<String> result;
        int counter = 0;

        File file = new File(fileName);

        try {
            result = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String element : result) {
            String[] wordsOfElement = element.split("\\W+");
            for (String currentElement : wordsOfElement) {
                if (currentElement.toLowerCase().charAt(0) == 'w') {
                    wordsWithW[counter] = currentElement.toLowerCase();
                    counter++;
                }
            }

        }
        Arrays.sort(wordsWithW);
        return wordsWithW;
    }

    public int getSizeForArray(String fileName) {
        File file = new File(fileName);
        List<String> result;
        int count = 0;

        try {
            result = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String element : result) {
            String[] wordsOfElement = element.split(" ");
            for (String currentElement : wordsOfElement) {
                if (currentElement.toLowerCase().charAt(0) == 'w') {
                    count++;
                }
            }
        }
        return count;
    }
}
