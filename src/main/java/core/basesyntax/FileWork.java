package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] result = new String[0];
        if (!stringBuilder.toString().isEmpty()) {
            result = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder resultW = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                char[] charArray = result[i].toCharArray();
                if (charArray[0] == SPECIFIED_CHARACTER) {
                    resultW.append(result[i]).append(" ");
                }
            }
            result = new String[0];
            if (!resultW.toString().isEmpty()) {
                String[] finalResult;
                finalResult = resultW.toString().split(" ");
                Arrays.sort(finalResult);
                return finalResult;
            }
        }
        return result;
    }
}
