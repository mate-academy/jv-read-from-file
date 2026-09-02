package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        double lineCount;
        char targetCharacter = 'w';

        try {
            lineCount = Files.lines(Paths.get(fileName)).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (lineCount == 0) {
            System.out.println("The file is empty.");
            return new String[0];
        }

        ArrayList<String> resultedList = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            Pattern re = Pattern.compile("[^A-Za-z ]+", Pattern.CASE_INSENSITIVE);

            for (int index = 0; index < lineCount; index++) {
                Matcher m = re.matcher(input.readLine());
                String result = m.replaceAll("");
                String[] words = result.split(" ");

                for (String word : words) {
                    if (word.toLowerCase().startsWith(String.valueOf(targetCharacter))) {
                        resultedList.add(word.toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] resultedArray = resultedList.toArray(new String[0]);
        Arrays.sort(resultedArray);
        return resultedArray;
    }
}

