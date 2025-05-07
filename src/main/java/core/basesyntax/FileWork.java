package core.basesyntax;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FileWork {
    public String[] readFromFile(String fileName) {
        String fileContent = readFileContent(fileName);
        if (fileContent.isEmpty()) {
            return new String[0];
        }

        String[] words = fileContent.split("\\s+");
        List<String> filteredWords = new ArrayList<>();
        Pattern punctuationPattern = Pattern.compile("\\p{Punct}");

        for (String word : words) {
            if (word.toLowerCase().startsWith("w")) {
                String filteredWord = punctuationPattern.matcher(word).replaceAll("");
                filteredWord = filteredWord.toLowerCase();
                filteredWords.add(filteredWord);
            }
        }

        String[] result = filteredWords.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }

    private String readFileContent(String fileName) {
        try {
            return Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
