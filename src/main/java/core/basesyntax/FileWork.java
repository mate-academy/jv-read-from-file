package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            List<String> words = Arrays.stream(content.split("[\\W_]+"))
                    .filter(word -> !word.isEmpty())
                    .map(String::toLowerCase)
                    .filter(word -> word.startsWith("w"))
                    .sorted()
                    .collect(Collectors.toList());

            return words.toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file" + fileName);
        }
    }

    public static void main(String[] args) {
        String filePath = "test1";
        String filePath2 = "test2";
        String filePath3 = "test3";
        String filePath4 = "test4";
        String filePath5 = "test5";

        String[] result = readFromFile(filePath);

        System.out.println(Arrays.toString(result));
    }
}
