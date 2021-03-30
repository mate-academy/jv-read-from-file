package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Path pathToTest = Paths.get(fileName);
        File fileTo = pathToTest.toFile();
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileTo))) {
            String value = reader.readLine();

            while (value != null) {
                for (String line : value.split(" ")) {

                    if (line.toLowerCase().charAt(0) == 'w') {
                        builder.append(" ").append(line.toLowerCase()
                                .replace(".", "").replace(",", "")
                                .replace("!", "").replace("?", ""));
                    }
                }
                value = reader.readLine();
            }

            if (!builder.toString().equals("")) {
                String[] result = builder.toString().trim().split(" ");
                Arrays.sort(result);
                return result;
            }

            return new String[0];
        } catch (IOException e) {
            throw new RuntimeException("File not found.", e);
        }
    }
}
