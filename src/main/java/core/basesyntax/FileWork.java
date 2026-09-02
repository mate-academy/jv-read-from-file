package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String input = readStringFromFile(fileName);
        String[] wordsArray = getWordsArrayFromString(input);
        String[] result = new String[0];

        for (String s : wordsArray) {
            if (s.startsWith("W") || s.startsWith("w")) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s.toLowerCase();
            }
        }

        Arrays.sort(result);
        return result;
    }

    public String[] getWordsArrayFromString(String string) {
        return string.split("\\W+");
    }

    public String readStringFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                content.append(line).append("\n");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        System.out.println(Arrays.toString(fileWork.readFromFile("test5")));
    }
}
