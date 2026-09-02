package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private static final String ragexSymbol = " ";

    public String[] readFromFile(String fileName) {
        Path pathOfFileName = Path.of(fileName);
        try {
            List<String> lines = Files.readAllLines(pathOfFileName);
            if (lines.isEmpty()) {
                return new String[]{};
            }
            String[] valuesFromList = lines.toArray(new String[]{});
            StringBuilder stringBuilder = new StringBuilder();
            for (String words : valuesFromList) {
                String[] wordsFromValuesFromList = words.split(ragexSymbol);
                for (String word : wordsFromValuesFromList) {
                    if (startWithLetter(word.toLowerCase())) {
                        String wword = word.toLowerCase();
                        String clearWWord = wword.replaceAll("\\p{Punct}", "");
                        stringBuilder.append(clearWWord).append(ragexSymbol);
                    }
                }
            }
            if (stringBuilder.toString().isEmpty()) {
                return new String[]{};
            }
            String[] result = stringBuilder.toString().split(ragexSymbol);
            Arrays.sort(result);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }
}
