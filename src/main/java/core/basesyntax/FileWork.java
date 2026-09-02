package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sentence = new StringBuilder();
            String value = bufferedReader.readLine();

            while (value != null) {
                sentence.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }

            String[] list = sentence.toString().toLowerCase().split("\\W+");
            int count = 0;

            for (String word : list) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    count++;
                }
            }

            String[] result = new String[count];
            int index = 0;

            for (String word : list) {
                if (word.startsWith(SPECIFIED_CHARACTER)) {
                    result[index++] = word;
                }
            }

            Arrays.sort(result);

            bufferedReader.close();
            return result;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
