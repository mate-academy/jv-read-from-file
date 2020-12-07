package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileWork {
    private static final char SYMBOL_LOWER_CASE = 'w';

    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                for (String value : line) {
                    if (Character.toLowerCase(value.charAt(0)) == SYMBOL_LOWER_CASE) {
                        list.add(value.replaceAll("[^A-z]","").toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("File %s not found. Try again",fileName), e);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Some problem with file %s. Try again", fileName), e);
        }
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
}
