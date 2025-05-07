package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        List<String> resultList = new ArrayList<>();

        try {
            List<String> stringList = Files.readAllLines(file.toPath());
            for (String line : stringList) {
                List<String> splitedLine = new ArrayList<>(List.of(line.toLowerCase()
                        .split("\\W+")));

                for (String words : splitedLine) {
                    if ('w' == words.charAt(0)) {
                        resultList.add(words);
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(resultList);
        String[] resultArray = resultList.toArray(new String[0]);
        return resultArray;
    }
}
