package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {

        String[] arrayWords = getDataFromFile(fileName).toString().toLowerCase().split("\\W+");
        if (arrayWords.length == 0) {
            return new String[]{};
        }
        StringBuilder data = new StringBuilder();
        for (String word : arrayWords) {
            if (word.startsWith("w")) {
                data.append(word).append(System.lineSeparator());
            }
        }
        arrayWords = data.toString().split(System.lineSeparator());
        if (arrayWords.length == 1 && !arrayWords[0].startsWith("w")) {
            return new String[]{};
        }
        Arrays.sort(arrayWords);
        return arrayWords;
    }

    private StringBuilder getDataFromFile(String path) {
        File file = new File(path);
        StringBuilder dataFromFile = new StringBuilder();
        try {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            int line = reader.read();
            while (line != -1) {
                dataFromFile.append((char) line);
                line = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return dataFromFile;
    }
}
