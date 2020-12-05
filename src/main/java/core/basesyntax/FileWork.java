package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        List<String> stringsList;
        try {
            stringsList = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Text read failed!", e);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringsList) {
            stringBuilder.append(string.toLowerCase()).append(" ");
        }

        String[] arrayText = stringBuilder.toString().split(" ");
        List<String> readFiles = new ArrayList<>();
        for (String string : arrayText) {
            if (string.startsWith(SPECIFIED_CHARACTER)) {
                readFiles.add(string.replaceAll("\\W", ""));
            }
        }
        Collections.sort(readFiles);
        return readFiles.toArray(new String[0]);
    }
}
