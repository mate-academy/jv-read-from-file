package core.basesyntax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        public static String[] filterWordsFromFile(String fileName) {
            // Regular expression pattern to match words starting with 'w'
            Pattern pattern = Pattern.compile("\\b[wW]\\w*\\b");

            List<String> wordsList = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+");
                    wordsList.addAll(Arrays.asList(words));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Filter words starting with 'w'
            List<String> filteredWords = new ArrayList<>();
            for (String word : wordsList) {
                if (pattern.matcher(word).matches()) {
                    filteredWords.add(word);
                }
            }

            // Sort the filtered words naturally
            String[] result = filteredWords.toArray(new String[0]);
            Arrays.sort(result, String.CASE_INSENSITIVE_ORDER);

            return result;
    }
}
