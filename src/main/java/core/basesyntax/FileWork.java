package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            File myFile = new File(fileName);
            if (!myFile.exists() || !myFile.isFile()) {
                throw new RuntimeException("Файл не існує або не є файлом");
            }

            ArrayList<String> allWords = new ArrayList<>(); // Ініціалізація списку allWords
            FileReader fileReader = new FileReader(myFile);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    // Заміна розділових знаків на порожній рядок та перетворення на нижній регістр
                    String cleanedWord = word.replaceAll("[?!,.]", "").toLowerCase();
                    if (!cleanedWord.isEmpty() && (cleanedWord.charAt(0) == 'w')) {
                        allWords.add(cleanedWord);
                    }
                }
            }
            // Сортування слів в алфавітному порядку
            Collections.sort(allWords);

            return allWords.toArray(new String[0]);
        } catch (Exception e) {
            throw new RuntimeException("Помилка при читанні з файлу", e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                throw new RuntimeException("Помилка при закритті потоку", e);
            }
        }
    }
}
