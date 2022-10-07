package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        final String First_Char = ("w");
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String ind = bufferedReader.readLine();

            while (ind != null) {
                builder.append(ind.toLowerCase())
                        .append(System.lineSeparator());
                ind = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e + "Can't read a file");
        }

        String[] words = builder.toString().split("\\W+");
        int length = 0;

        for (String word : words) {
            if (word.startsWith(First_Char)) {
                length++;
            }
        }

        String[] result = new String[length];
        int index = 0;

        for (String word : words) {
            if (word.startsWith(First_Char)) {
                result[index] = word;
                index++;
            }
        }

        Arrays.sort(result);
        return result;
    }
}
