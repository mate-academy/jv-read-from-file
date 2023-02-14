package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Iterable<String> lines = getLinesFromFile(fileName);
        ArrayList<String> result = new ArrayList<>();
        for (String line : lines) {
            result.addAll(
                    List.of(Arrays.stream(line.replaceAll("[^a-zA-Z ]", "").toLowerCase()
                            .split("\\s+"))
                            .filter(word -> word.startsWith("w")).toArray(String[]::new)));
        }
        return result.stream().sorted().toArray(String[]::new);
    }

    private Iterable<String> getLinesFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.lines().collect(Collectors.toCollection(ArrayList::new));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with name " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from the file " + fileName, e);
        }
    }
}
