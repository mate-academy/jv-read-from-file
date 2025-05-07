package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder readFile = new StringBuilder();
        StringBuilder sortWords = new StringBuilder();
        String[] resultReadFile = {};
        String[] sortReadFile = {};
        boolean isNoEmpty = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = bufferedReader.read();
            while (value != -1) {
                readFile.append((char) value);
                value = bufferedReader.read();
            }
            String [] wordsReadFile = readFile.toString().toLowerCase().trim()
                        .split("[?|!|-|(|)|:|;|'|\"| |.|,|\\s+|\\t|\\n|\\r|\\f]");
            Arrays.sort(wordsReadFile, Comparator.naturalOrder());
            int index;
            for (int i = 0; i < wordsReadFile.length; i++) {
                index = i;
                if (isSymbol(wordsReadFile[i])) {
                    isNoEmpty = true;
                    sortWords.append(wordsReadFile[i]).append(" ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't to read file", e);
        }
        if (isNoEmpty) {
            return resultReadFile = sortWords.toString().split(" ");
        }
        return resultReadFile;
    }

    private boolean isSymbol(String words) {
        return (words.startsWith("w") || words.startsWith("W"));
    }
}
