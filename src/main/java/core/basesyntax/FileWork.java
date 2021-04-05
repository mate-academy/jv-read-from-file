package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private static final char FILTER_CHARACTER = 'w';
    private static final String SEPARATOR_CHARACTER = "_";
    private static final String SECOND_SEPARATOR_CHARACTER = " ";
    private static final String EMPTY_CHARACTER = "";

    public String[] readFromFile(String fileName) {
        try {
            StringBuilder result = new StringBuilder();
            StringBuilder list = new StringBuilder();
            List<String> files = Files.readAllLines(Paths.get(fileName));
            if (files.isEmpty()) {
                return new String[0];
            }
            for (int i = 0; i < files.size(); i++) {
                list.append(files.get(i)).append(SECOND_SEPARATOR_CHARACTER);
            }
            String[] listSplit = list.toString().split(SECOND_SEPARATOR_CHARACTER);
            for (int i = 0; i < listSplit.length; i++) {
                if (listSplit[i].toLowerCase().charAt(0) == FILTER_CHARACTER) {
                    result.append(listSplit[i].toLowerCase()).append(SEPARATOR_CHARACTER);
                }
            }
            if (result.toString().isEmpty()) {
                return new String[0];
            }
            String[] resultArr = result.toString().trim()
                    .replaceAll("\\W", EMPTY_CHARACTER)
                    .split(SEPARATOR_CHARACTER);
            Arrays.sort(resultArr);
            return resultArr;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
    }
}
