package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");

            }
            String string = stringBuilder.toString();
            String[] m = string.split("\\W+");

            int count = 0;
            for (String element : m) {
                String sequence = element.toLowerCase();
                if (!sequence.isEmpty() && sequence.charAt(0) == 'w') {
                    count++;
                }
            }

            String[] result = new String[count];
            int index = 0;

            for (String element : m) {
                String sequence = element.toLowerCase();
                if (!sequence.isEmpty() && sequence.charAt(0) == 'w') {
                    result[index] = sequence;
                    index++;
                }
            }

            Arrays.sort(result);
            return result;

        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

    }

}
