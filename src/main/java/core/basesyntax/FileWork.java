package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public static final String FILE_NAME = "test2";

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        fileWork.readFromFile(FILE_NAME);
    }

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String text = null;

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            text = String.join(" ", lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        String[] sentences = text.split("[^A-Za-z0-9 ]+");
        List<String> result = new java.util.ArrayList<>();

        for (String sentence : sentences) {
            for (String word : sentence.split(" ")) {
                String normalizedWord = word.toLowerCase();
                String firstLetter = normalizedWord.split("")[0];

                if (firstLetter.equals("w")) {
                    result.add(normalizedWord);
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[result.size()]);
    }
}
