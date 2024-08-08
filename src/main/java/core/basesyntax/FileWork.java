package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final String REGEX = "\\W+";
    public static final String SPACE = " ";
    public static final String STARTING_CHAR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String fileContent = "";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder fileContentStringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                fileContentStringBuilder.append(value).append(SPACE);
                value = bufferedReader.readLine();
            }

            fileContent = fileContentStringBuilder.toString().toLowerCase();

            String[] noPunctuationFileContent = fileContent.split(REGEX);
            Arrays.sort(noPunctuationFileContent);
            StringBuilder punctuationStringBuilder = new StringBuilder();

            for (int i = 0; i < noPunctuationFileContent.length; i++) {
                if (noPunctuationFileContent[i].startsWith(STARTING_CHAR)) {
                    punctuationStringBuilder
                            .append(noPunctuationFileContent[i])
                            .append(SPACE);
                }
            }

            String result = punctuationStringBuilder.toString().trim();

            if (result.isEmpty()) {
                return new String[0];
            }

            String[] resultArray = result.split(SPACE);

            return resultArray;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong while processing a file: ", e);
        }
    }
}
