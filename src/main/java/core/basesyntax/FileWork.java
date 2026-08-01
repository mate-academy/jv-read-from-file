package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {

    private static final String SPECIFIED_CHARACTER = "w";
    private String content;

    public String[] readFromFile(String fileName) {

        try {
            content = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Reading file error" + " " + fileName + " " + e);
        }
        String[] words = content.split("\\W+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (!word.isEmpty() && word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                result.add(word.toLowerCase());
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        FileWork fileWork = new FileWork();
        fileWork.readFromFile("test4.txt");
    }
}



