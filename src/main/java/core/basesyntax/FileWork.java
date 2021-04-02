package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWork {
    public static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> arrayWords = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String sentence = bufferedReader.readLine();
            while (sentence != null) {
                for (String word : sentence.split(" ")) {
                    if (word.toLowerCase().startsWith(SPECIFIED_CHARACTER)) {
                        arrayWords.add(word.replaceAll("\\W", "").toLowerCase());
                    }
                }
                sentence = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found.");
        } catch (IOException e) {
            throw new RuntimeException("Cant read the file.");
        }

        String[] resultWords = arrayWords.toArray(new String[arrayWords.size()]);
        Arrays.sort(resultWords);
        return resultWords;
    }
}
