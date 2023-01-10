package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String DELIMITER = "\\W+";

    public String[] readFromFile(String fileName) {
        String[] result;
        File file = new File(fileName);

        try {
            List<String> fileInfo = Files.readAllLines(file.toPath());
            result = validateFileInfo(fileInfo);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName, e);
        }

        return result;
    }

    private String[] validateFileInfo(List<String> fileInfo) {
        List<String> result = new ArrayList<>();

        for (String fileItem : fileInfo) {
            String[] splitFileItem = fileItem.toLowerCase().split(DELIMITER);
            Arrays.stream(splitFileItem).filter(s -> s.startsWith("w")).forEach(result::add);
        }

        if (result.size() != 0) {
            Collections.sort(result);
            return result.toArray(new String[0]);
        }

        return new String[0];
    }
}
