package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();

            while (value != null) {
                String[] str = value.split("\\W+");

                for (String element : str) {
                    if (element.toLowerCase().charAt(0) == 'w') {
                        builder.append(element.toLowerCase()).append(" ");
                    }
                }

                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (builder.toString().isEmpty()) {
            return new String[0];
        }

        String[] result = builder.toString().trim().split(" ");
        Arrays.sort(result);

        return result;
    }
}
