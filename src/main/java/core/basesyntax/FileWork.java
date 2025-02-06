package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        Alfavit alfavit = new Alfavit();
        File file = new File(fileName);

        if (file.length() == 0) {
            return new String[0]; // Якщо файл порожній, повертаємо порожній масив
        }

        List<String> words = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                // Розбиваємо рядок на слова, ігноруючи пунктуацію
                String[] tokens = line.split("\\W+");

                for (String word : tokens) {
                    if (!word.isEmpty() && (word.startsWith("w") || word.startsWith("W"))) {
                        words.add(word.toLowerCase()); // Додаємо слово у нижньому регістрі
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }

        // Повертаємо масив замість List
        return alfavit.returnAlfWords(words.toArray(new String[0]));
    }
}


