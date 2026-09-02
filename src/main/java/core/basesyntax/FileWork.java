package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            Path path = Path.of(fileName);
            if (Files.size(path) == 0) {
                return new String[0];
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                String[] valueArray = value.split("[,.'!? ]");
                for (String parArray : valueArray) {
                    if (parArray.toLowerCase().startsWith("w")) {
                        stringBuilder.append(parArray.toLowerCase() + " ");
                    }
                }
                value = bufferedReader.readLine();
            }
            if (stringBuilder.isEmpty()) {
                return new String[0];
            }
            String stringResult = stringBuilder.toString();
            String[] arrayResult = stringResult.split(" ");
            Arrays.sort(arrayResult);
            return arrayResult;
        } catch (IOException e) {
            throw new RuntimeException("Cant read file",e);
        }
    }
}
