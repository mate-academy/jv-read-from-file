package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                value = value.toLowerCase().replaceAll("\\b(?!w)\\w+\\W*", "");
                value = value.replaceAll("[.]","");
                if (value != "") {
                    String[] words = value.split("[\\W++&&[^-]]");
                    stringBuilder.append(Arrays.toString(words));
                }
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find the file", e);
        } catch (IOException ex) {
            throw new RuntimeException("Can't read the file", ex);
        }
        String word = stringBuilder.toString().replaceAll("\\s++","");
        if (word == "") {
            return new String[]{};
        }
        word = word.replaceAll("[\\W++&&[^-]]",".");
        word = word.replaceAll("\\B[.]","");
        String[] sorted = word.split("[.]++");
        Arrays.sort(sorted);
        return sorted;
    }
}
