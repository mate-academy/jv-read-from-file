package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader buffer = new BufferedReader(
                new FileReader(fileName))) {
            String str;
            while ((str = buffer.readLine()) != null) {
                stringBuilder.append(str).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("cant read file", e);
        }
        String toCheck = stringBuilder.toString();
        String[] dirtyArray = toCheck.replaceAll("\\pP", "").split(" ");
        String firstB;
        int cleanArrayLength = 0;
        int index = 0;
        for (int i = 0; i < dirtyArray.length; i++) {
            if (dirtyArray[i].isEmpty()) {
                continue;
            }
            firstB = dirtyArray[i].substring(0, 1);
            if (firstB.equalsIgnoreCase("w")) {
                cleanArrayLength++;
            }
        }
        String[] cleanArray = new String[cleanArrayLength];
        for (int i = 0; i < dirtyArray.length; i++) {
            if (dirtyArray[i].isEmpty()) {
                continue;
            }
            firstB = dirtyArray[i].substring(0, 1);
            if (firstB.equalsIgnoreCase("w")) {
                cleanArray[index] = dirtyArray[i].toLowerCase();
                index++;
            }
        }
        Arrays.sort(cleanArray);
        return (cleanArray.length == 0) ? new String[0] : cleanArray;
    }
}
