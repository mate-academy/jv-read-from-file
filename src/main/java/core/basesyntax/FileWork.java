package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        char targetLetter = 'w';
        List<String> dynamicArray = new ArrayList<>();
        Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]+", Pattern.CASE_INSENSITIVE);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split("\\s+");
                for (String word : splitLine) {
                    String lowerCaseWord = word.toLowerCase();
                    if (lowerCaseWord.startsWith(String.valueOf(targetLetter))) {
                        Matcher matcher = pattern.matcher(lowerCaseWord);
                        String result = matcher.replaceAll("");
                        dynamicArray.add(result);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't be split!", e);
        }

        Collections.sort(dynamicArray);
        String[] finalResult = new String[dynamicArray.size()];
        finalResult = dynamicArray.toArray(finalResult);

        return finalResult;
    }
}
