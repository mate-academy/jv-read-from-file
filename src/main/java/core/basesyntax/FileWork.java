package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String textFromFile;
            while ((textFromFile = bufferedReader.readLine()) != null) {
                stringBuilder.append(textFromFile).append(" ");
            }

            String[] splittedTextFromFile = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder builderResult = new StringBuilder();
            for (String word : splittedTextFromFile) {
                if (word.startsWith("w")) {
                    builderResult.append(word).append(" ");
                }
            }

            if (builderResult.isEmpty()) {
                return new String[0];
            }

            String[] result = builderResult.toString().split(" ");
            Arrays.sort(result);
            return result;

        } catch (FileNotFoundException exception) {
            System.out.println("File not found" + fileName);
            return new String[0];
        } catch (IOException e) {
            System.out.println("Can`t read file" + fileName);
            return new String[0];
        }
    }
}
