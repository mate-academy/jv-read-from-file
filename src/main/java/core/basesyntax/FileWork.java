package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        char specifiedCharacter = 'w';
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                String[] words = value.split("\\s+");
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-zA-Zа-яА-Я0-9]", "");
                    if (!cleanedWord.isEmpty() && cleanedWord.toLowerCase(Locale.ROOT)
                            .startsWith(String.valueOf(specifiedCharacter))) {
                        stringBuilder.append(cleanedWord.toLowerCase(Locale.ROOT)).append(' ');
                    }
                }
                value = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] result;
        if (stringBuilder.length() > 0) {
            result = stringBuilder.toString().split("\\s+");
            Arrays.sort(result, String.CASE_INSENSITIVE_ORDER);
        } else {
            System.out.println("No words found starting with 'w'");
            result = new String[0];
        }

        return result;
    }
}
