package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String readerFile = reader.readLine();
            while (readerFile != null) {
                stringBuilder.append(readerFile).append(System.lineSeparator());
                readerFile = reader.readLine();
            }

            String[] splitFile = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder withLetterW = new StringBuilder();
            for (String split:splitFile) {
                if (split.startsWith(SPECIFIED_CHARACTER)) {
                    withLetterW.append(split).append(" ");
                }
            }

            String[] fileOnlyWithLetterW = withLetterW.toString().split(" ");
            Arrays.sort(fileOnlyWithLetterW);
            return file.length() == 0 || fileOnlyWithLetterW.length <= 1
                    ? new String[0] : fileOnlyWithLetterW;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
