package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final int FIRST_INDEX = 0;

    public String[] readFromFile(String fileName) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] splitStrings = readLine.replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase().split("\\s+");
                for (String word : splitStrings) {
                    if (word.charAt(FIRST_INDEX) == 'w'
                            || word.charAt(FIRST_INDEX) == 'W') {
                        arrayList.add(word);
                    }
                }
            }
            Collections.sort(arrayList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File does not exist", e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file", e);
        }
        return arrayList.toArray(new String[FIRST_INDEX]);
    }
}
