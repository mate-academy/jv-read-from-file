package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> wordsStartingWithW = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            String content = String.join(" ", lines).toLowerCase();

            content = content.replaceAll("[^\\w\\s]", "");

            String[] words = content.split("\\s+");

            wordsStartingWithW = Arrays.stream(words)
                    .filter(word -> word.startsWith("w"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(wordsStartingWithW);

        return wordsStartingWithW.toArray(new String[0]);
    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();

        String[] result = fileWork.readFromFile("path_to_your_file.txt");
        System.out.println(Arrays.toString(result));
    }
}
