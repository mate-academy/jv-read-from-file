package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWork {
    private final StringBuilder stringBuilder = new StringBuilder();

    public String[] readFromFile(String fileName) {
        if (fileName.isEmpty()) {
            return new String[0];
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String str = bufferedReader.readLine();
            while (str != null) {
                stringBuilder.append(str).append(" ");
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splitArr = stringBuilder.toString().split("\\s+");
        List<String> stringList = new ArrayList<>();
        for (String s : splitArr) {
            if (s.toLowerCase().startsWith("w")) {
                stringList.add(s.toLowerCase().replaceAll("\\W+", ""));
            }
        }
        return stringList.stream().sorted().toArray(String[]::new);
    }
}
