package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    private static final char SYMBOL_LOWER_CASE = 'w';
    private static final char SYMBOL_UPPER_CASE = 'W';

    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String value : line) {
                    if (value.charAt(0) == SYMBOL_LOWER_CASE
                            || value.charAt(0) == SYMBOL_UPPER_CASE) {
                        list.add(value.replaceAll("[^A-z]","").toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found. Try again", e);
        } catch (IOException e) {
            throw new RuntimeException("Some problem with file. Try again", e);
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}
