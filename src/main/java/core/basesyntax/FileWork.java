package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder fileText = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                fileText.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            String[] arrTexts = fileText.toString().toLowerCase().split("\\W+");
            ArrayList<String> text = new ArrayList<>();
            for (String arrText : arrTexts) {
                if (!arrText.isEmpty() && arrText.startsWith("w")) {
                    if (arrText.startsWith("w")) {
                        text.add(arrText);
                    }
                }
            }
            Collections.sort(text);
            return text.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t found the file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read the file", e);
        }
    }
}
