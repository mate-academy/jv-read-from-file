package core.basesyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String> allSortedWords = new LinkedList<>();
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split(" "))
                        .map(String::toLowerCase)
                        .filter(s -> s.charAt(0) == 'w').map(s -> {
                            char last = s.charAt(s.length() - 1);
                            if (!(last >= 'a' && last <= 'z')) {
                                s = s.substring(0, s.length() - 1);
                            }
                            return s;
                        }).forEach(allSortedWords::add);
            }
            return allSortedWords.stream().sorted().toArray(String[]::new);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return new String[0];
    }
}
