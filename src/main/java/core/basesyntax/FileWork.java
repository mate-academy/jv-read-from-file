package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                builder.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file", e);
        }
        return filterWords(builder.toString());
    }

    private String[] filterWords(String dataFromFile) {
        if (dataFromFile == null || dataFromFile.equals("")) {
            return new String[0];
        }
        String[] withoutSort = dataFromFile.split("\\W+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : withoutSort) {
            if (s.charAt(0) == 'w' || s.charAt(0) == 'W') {
                stringBuilder.append(s.toLowerCase()).append(" ");
            }
        }
        if (stringBuilder.isEmpty()) {
            return new String[0];
        }
        String[] result = stringBuilder.toString().split(" ");
        Arrays.sort(result);
        return result;
    }
}
