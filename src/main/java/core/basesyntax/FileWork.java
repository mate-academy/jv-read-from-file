package core.basesyntax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileWork {
    public static String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            List<String> filteredWords = new ArrayList<>();
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (word.startsWith("w")) {
                    String filteredWord = word.replaceAll("[^a-zA-Z0-9]", "");
                    filteredWords.add(filteredWord);
                }
            }

            if (filteredWords.size() == 0) {
                return new String[0];
            }

            filteredWords.sort((a, b) -> NaturalOrderComparator.compare(a, b));
            return filteredWords.toArray(new String[0]);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return new String[0];
        }
    }

    private static class NaturalOrderComparator {
        private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d+");

        public static int compare(String a, String b) {
            String[] atokens = DIGIT_PATTERN.split(a);
            String[] btokens = DIGIT_PATTERN.split(b);

            int i = 0;
            while (i < atokens.length && i < btokens.length) {
                int diff = compareTokens(atokens[i], btokens[i]);
                if (diff != 0) {
                    return diff;
                }
                i++;
            }
            return atokens.length - btokens.length;
        }

        private static int compareTokens(String a, String b) {
            if (a.matches("\\d+") && b.matches("\\d+")) {
                return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
            } else {
                return a.compareTo(b);
            }
        }
    }
}
