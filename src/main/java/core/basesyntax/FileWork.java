package core.basesyntax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    public static final char SPECIFIED_CHARACTER = 'w';

    private StringBuilder strBuilder = new StringBuilder();
    private List<String> stringList;

    public String[] readFromFile(String fileName) {
        try {
            stringList = Files.readAllLines((new File(fileName).toPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + fileName);
        }
        for (String strLine : stringList) {
            String[] words = strLine.toLowerCase().split("\\W+");
            for (String str : words) {
                if (str.charAt(0) == SPECIFIED_CHARACTER) {
                    strBuilder.append(str).append(" ");
                }
            }
        }
        if (strBuilder.toString().length() == 0) {
            return new String[0];
        }
        String[] result = strBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
