package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public static final String REGEX_DELIMITER = "\\W+";
    public static final char FIRST_CHAR = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            int value = (char) bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char)value);
                value = bufferedReader.read();
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + fileName, e);
        }
        List<String> list = Arrays.stream(stringBuilder.toString().split(REGEX_DELIMITER))
                            .map(s -> s.toLowerCase())
                            .filter(s -> s.charAt(0) == FIRST_CHAR).sorted()
                            .collect(Collectors.toList());
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }
}
