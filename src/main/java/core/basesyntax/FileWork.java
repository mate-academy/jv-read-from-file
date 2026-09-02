package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    private static final String SPLITTERATOR = "[!?.,;:\\-_ `'\n\r]";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(readFromFile("test2")));
    }

    public static String[] readFromFile(String fileName) {
        ArrayList<String> wordsList = new ArrayList<String>();
        File file = new File(fileName);
        try {
            for (String word : Files.readString(Path.of(file.getPath())).split(SPLITTERATOR)) {
                if (word.matches("(w|W).*")) {
                    wordsList.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] words = wordsList.toArray(String[]::new);
        Arrays.sort(words);
        return words;
    }
}
