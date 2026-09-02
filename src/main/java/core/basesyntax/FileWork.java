package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String START_CHAR = "w";
    // Регулярний вираз для розбиття: шукає один або більше символів, які не є літерами
    private static final String REGEX_SPLIT = "[^a-zA-Z]+";

    public String[] readFromFile(String fileName) {
        // Використовуємо List, щоб зберегти всі входження слів, включаючи дублікати
        List<String> resultWordsList = new ArrayList<>();
        String content;

        try {
            // 1. Читання вмісту файлу
            content = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            // Обробка помилки читання
            return new String[0];
        }

        // Перевірка на порожній файл або порожній рядок
        if (content.isEmpty()) {
            return new String[0];
        }

        // 2. Перетворення всього тексту на нижній регістр
        String lowerCaseContent = content.toLowerCase();

        // 3. Розбиття рядка на окремі слова за всіма розділовими знаками/пробілами
        String[] allWords = lowerCaseContent.split(REGEX_SPLIT);

        // 4. Фільтрація
        for (String word : allWords) {
            // Важливо: перевіряємо, чи слово не порожнє (результат split може містити "")
            if (!word.isEmpty() && word.startsWith(START_CHAR)) {
                // Додаємо слово до списку (включаючи дублікати)
                resultWordsList.add(word);
            }
        }

        // 5. Сортування результату
        // Використовуємо природне сортування (алфавітне)
        Collections.sort(resultWordsList);

        // 6. Повернення масиву
        return resultWordsList.toArray(new String[0]);
    }
}
