package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String CONSTANT_LETTER = "w";
    private static final String SHOULD_BE_DELETED_AT_FINAL_ARRAY = "(?u)[^\\pL ]";
    private static final String REPLACEMENT_OF_INAPPROPRIATE = " ";

    public String[] readFromFile(String fileName) {
        StringBuilder wordsStartingWithConstant = new StringBuilder();
        int wordsWithConstant = 0;
        try {
            String fileData = Files.readString(Path.of(fileName))
                    .replaceAll(SHOULD_BE_DELETED_AT_FINAL_ARRAY, REPLACEMENT_OF_INAPPROPRIATE);

            for (String lineData : fileData.split(" ")) {
                if (lineData.toLowerCase().startsWith(CONSTANT_LETTER)) {
                    wordsStartingWithConstant.append(lineData).append(" ");
                    wordsWithConstant++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading the file", e);
        }

        if (wordsStartingWithConstant.length() == 0) {
            return new String[0];
        }
        String [] resultArray;
        resultArray = wordsStartingWithConstant.toString().trim().toLowerCase().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
