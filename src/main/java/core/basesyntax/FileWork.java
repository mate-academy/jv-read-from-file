package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final char SPECIFIED_CHARACTER = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read the file", e);
        }
        String[] stringArray = stringBuilder.toString().toLowerCase()
                .split("\\s+");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replaceAll("[^a-z]", "");
        }
        int specifiedCharWordsCounter = 0;
        for (String stringStartedAtW : stringArray) {
            if(stringStartedAtW.charAt(0) == SPECIFIED_CHARACTER) {
                specifiedCharWordsCounter++;
            }
        }
        if (specifiedCharWordsCounter == 0) {
            return new String[0];
        }
        String[] filteredArray = new String[specifiedCharWordsCounter];
        int j = 0;
        for (String word : stringArray) {
            if (!word.isEmpty() && word.charAt(0) == SPECIFIED_CHARACTER) {
                filteredArray[j] = word; // Добавляем слово в массив
                j++; // Увеличиваем индекс для следующего элемента
            }
        }
        Arrays.sort(filteredArray);

    return filteredArray;
    }
}
