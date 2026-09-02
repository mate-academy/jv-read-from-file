package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(
                                                    new FileReader(new File(fileName)))) {

            String lineFromFile = bufferedReader.readLine();
            while (lineFromFile != null) {
                String[] words = lineFromFile.split("\\W+");

                addSpecialWordToResult(result, words);

                lineFromFile = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + fileName + " not found!", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }

        result.sort(null);

        return result.toArray(new String[result.size()]);
    }

    private void addSpecialWordToResult(ArrayList<String> result, String[] data) {
        for (String word : data) {
            if (startWithLetter(word.toLowerCase())) {
                result.add(word.toLowerCase());
            }
        }
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
