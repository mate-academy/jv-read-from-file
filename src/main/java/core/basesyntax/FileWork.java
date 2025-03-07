package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {

    public List<String> readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try {
            String content = Files.readString(Path.of(fileName));
            String[] works = content.replaceAll("[^a-zA-Z ]", "").split("\\s+");
            result = Arrays.stream(works)
                    .map(String::toLowerCase)
                    .filter(work -> work.toLowerCase().startsWith("w"))
                    .sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return result;
    }
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        List<String> works = fileWork.readFromFile("example.txt");
        System.out.println(works);
    }
}

