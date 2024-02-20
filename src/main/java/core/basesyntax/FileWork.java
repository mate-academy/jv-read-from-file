package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileWork {
    private static String FIND_WORD_REGEX = "\\b[wW]\\w+";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> resultList = new ArrayList<>();
        try {
            List<String> strings = Files.readAllLines(file.toPath());
            Pattern pattern = Pattern.compile(FIND_WORD_REGEX);

            for (String string: strings) {
                Matcher matcher = pattern.matcher(string);
                while (matcher.find()) {
                    resultList.add(matcher.group().toLowerCase());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant`t read file", e);
        }
        Collections.sort(resultList);
        String[] result = resultList.toArray(new String[0]);
        return result;
    }
}
