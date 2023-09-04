package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            String fileString = new String(Files.readAllBytes(file.toPath()));
            String[] array = fileString.replaceAll("\n", " ").split(" ");
            StringBuilder builder = new StringBuilder();
            for (String str : array) {
                if (str.toLowerCase()
                        .replaceAll("\\W", "")
                        .startsWith("w")) {
                    builder
                            .append(str.toLowerCase().replaceAll("\\W", ""))
                            .append(System.lineSeparator());
                }
            }
            String[] resultArray = builder.toString().split(System.lineSeparator());
            Arrays.sort(resultArray);
            if (resultArray[0].equals("")) {
                return new String[0];
            }
            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
    }
}
