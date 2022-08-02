package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String row = bufferedReader.readLine();
            if (row == null) {
                return new String[0];
            }
            while (row != null) {
                stringBuffer.append(row).append(" ");
                row = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from the file " + fileName, e);
        }
        String[] words = stringBuffer.toString().split("[^A-Za-z0-9]+");
        for (String word : words) {
            if (word.toLowerCase().charAt(0) == 'w') {
                list.add(word.toLowerCase());
            }
        }
        Collections.sort(list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
