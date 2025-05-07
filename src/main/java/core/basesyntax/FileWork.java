package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    private static final String EMPTY_DELIMITER = "";
    private static final String SPACE_DELIMITER = " ";
    private static final String PUNCTUATION = "[!?,.;]";
    private static final String NEW_LINE_SIGN = "\n";
    private static final String[] EMPTY_ARRAY = new String[0];

    public String[] readFromFile(String fileName) {
        //write your code here
        Path pathToFile = Path.of(fileName);
        String[] result;

        try {
            byte[] fileAsByteArray = Files.readAllBytes(pathToFile);
            String fileContent = new String(fileAsByteArray)
                    .toLowerCase()
                    .replaceAll(PUNCTUATION, EMPTY_DELIMITER)
                    .replaceAll(NEW_LINE_SIGN, SPACE_DELIMITER);

            if (fileContent.length() == 0) {
                return EMPTY_ARRAY;
            }

            StringBuilder resultString = new StringBuilder();

            result = fileContent.split(SPACE_DELIMITER);

            for (String s : result) {
                if (s.charAt(0) == 'w') {
                    resultString.append(s).append(SPACE_DELIMITER);
                }
            }

            if (!resultString.toString().contains("w")) {
                return EMPTY_ARRAY;
            }

            result = resultString.toString().split(SPACE_DELIMITER);
            Arrays.sort(result);

            return result;
        } catch (IOException e) {
            System.out.println("Error reading from the file: " + e.getMessage());
            return EMPTY_ARRAY;
        }
    }
}
