package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path path = Path.of(fileName);
        String textFromFile;
        StringBuilder resultStrBuilder = new StringBuilder();
        int countOfW = 0;
        try {
            textFromFile = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        if (textFromFile.isEmpty()) {
            return new String[0];
        }
        String[] splitTextFromFile = textFromFile.toLowerCase().split("\\W+");
        for (int i = 0; i < splitTextFromFile.length; i++) {
            if (splitTextFromFile[i].charAt(0) == 'w') {
                countOfW++;
                resultStrBuilder.append(splitTextFromFile[i]).append(",");
            }
        }
        if (countOfW == 0) {
            return new String[0];
        }
        String[] result = resultStrBuilder.toString().split("\\W+");
        Arrays.sort(result);
        return result;
    }
}
