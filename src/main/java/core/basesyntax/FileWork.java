package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String[] result = new String[0];
    private String line;
    private String[] lineArray;
    private StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        int resultSize = 0;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                lineArray = line.split("\\W+");
                for (String word : lineArray) {
                    if (word.charAt(0) == 'w' || word.charAt(0) == 'W') {
                        stringBuilder.append(word.toLowerCase()).append(' ');
                    }
                }
            }
            if (stringBuilder.isEmpty()) {
                return result;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException("Can't close FileReader or BufferedReader", e);
            }
        }
        result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
