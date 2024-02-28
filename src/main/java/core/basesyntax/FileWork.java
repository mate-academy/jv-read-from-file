package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FileWork {
    private List<String> readFileToStrList(String fileName) {
        File file = new File(fileName);
        try (FileReader fileReader = new FileReader(file)) {
            return Files.readAllLines(file.toPath());
        } catch (Exception e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    private String sortAndFilterList(List<String> strings) {
        String [] stringLower = String.join(" ", strings).toLowerCase().split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringLower) {
            if (str.charAt(0) == 'w') {
                stringBuilder.append(str).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public String[] readFromFile(String fileName) {
        List<String> strings = readFileToStrList(fileName);
        if (strings.size() == 0) {
            return new String[0];
        }
        String str = sortAndFilterList(strings);
        if (str.equals("")) {
            return new String[0];
        }
        String [] result = str.split(" ");
        Arrays.sort(result);
        return result;
    }

}
