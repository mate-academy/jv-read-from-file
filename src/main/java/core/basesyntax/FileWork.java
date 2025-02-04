package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public String[] readFromText(String text) {
        List<String> wordsStartingWithW = new ArrayList<>();

        // Переведення тексту у нижній регістр та розділення за пробілами та пунктуацією
        String[] words = text.toLowerCase().split("[\\s\\p{Punct}]+");

        // Фільтрація слів, що починаються на "w"
        for (String word : words) {
            if (word.startsWith("w") && !word.isEmpty()) {
                wordsStartingWithW.add(word);
            }
        }

        // Сортування у природному порядку
        String[] result = wordsStartingWithW.toArray(new String[0]);
        Arrays.sort(result);

        return result;
    }
}
