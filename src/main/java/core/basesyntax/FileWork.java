package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static final String PUNCTUALITY_REG_EX = "[\\p{Punct}\\s]+";
    private static final String W_WORD_REG_EX = "\\b[wW]\\w*";

    public String[] readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            List<String> lines = Files.readAllLines(file.toPath());
            String[] resultArr = getArrayOfNeededWords(lines);
            Arrays.sort(resultArr);
            return resultArr;
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
    }

    public String[] getArrayOfNeededWords(List<String> lines) {
        List<String> resultList = new ArrayList<>();
        for (String line : lines) {
            resultList.addAll(wordFinder(line));
        }
        return resultList.toArray(new String[0]);
    }

    public List<String> wordFinder(String line) {
        List<String> result = new ArrayList<>();
        List<String> words = wordSeparator(line);
        for (String word : words) {
            Pattern pattern = Pattern.compile(W_WORD_REG_EX);
            Matcher matcher = pattern.matcher(word);
            while (matcher.find()) {
                result.add(matcher.group());
            }
        }
        return result;
    }

    public String wordFormatter(String word) {
        return word.replaceAll(PUNCTUALITY_REG_EX, "");
    }

    public List<String> wordSeparator(String line) {
        List<String> words = List.of(line.split(PUNCTUALITY_REG_EX));
        List<String> formattedWords = new ArrayList<>();
        for (String word : words) {
            formattedWords.add(wordFormatter(word).toLowerCase());
        }
        return formattedWords;
    }

}
