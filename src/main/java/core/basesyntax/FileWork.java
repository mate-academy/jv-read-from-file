package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            if (Files.size(Paths.get(fileName)) == 0) {
                return new String[0];
            }
            while (value != null) {
                stringBuilder.append(value).append(",");
                value = bufferedReader.readLine();
            }
            String allText = stringBuilder.toString();
            String[]allWords = allText.replaceAll("[^a-zA-Z0-9]+", " ")
                    .toLowerCase().split(" ");
            StringBuilder builder = new StringBuilder();
            for (String allWord : allWords) {
                if (allWord.startsWith("w")) {
                    builder.append(allWord).append(",");
                }
            }
            String resultStr = builder.toString();
            if (resultStr.isEmpty()) {
                return new String[0];
            }
            String[] result = resultStr.split(",");
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException("WFT?!", e);
        }
    }
}
