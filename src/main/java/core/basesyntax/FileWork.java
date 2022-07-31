package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileWork {
    private static final char UPPER_W = 'W';
    private static final char LOWER_W = 'w';
    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        StringBuilder inputReader = new StringBuilder();
        StringBuilder outputReader = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int temp = bufferedReader.read();
            while (temp != -1) {
                inputReader.append((char) temp);
                temp = bufferedReader.read();
            }
            String[] array = inputReader.toString().split("[ ',.?!\n]");
            for (String word : array) {
                if (word.equals("")) {
                    continue;
                }
                char[] chars = word.toCharArray();
                if (chars[0] == LOWER_W || chars[0] == UPPER_W) {
                    outputReader.append(word.toLowerCase()).append(" ");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        String[] strings = (outputReader.toString().split(" "));
        if (strings.length == 1) {
            return EMPTY_ARRAY;
        }
        return Stream.of(strings).sorted().toArray(String[]::new);
    }
}
