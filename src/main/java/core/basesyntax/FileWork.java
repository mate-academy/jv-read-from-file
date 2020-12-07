package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    private static final char STARTS_WITH = 'w';

    public String[] readFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new
                FileReader((fileName)))) {
            String newLine = bufferedReader.readLine();
            while (newLine != null) {
                stringBuilder.append(newLine.toLowerCase()).append(" ");
                newLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File was not found", e);
        } catch (IOException e) {
            throw new RuntimeException("File was not read", e);
        }
        String[] stringArr = stringBuilder.toString().split(" ");
        for (String string : stringArr) {
            if (startsWith(string)) {
                arrayList.add(string.replaceAll("[,.!?]", ""));
            }
        }
        stringArr = new String[arrayList.size()];
        Collections.sort(arrayList);
        arrayList.toArray(stringArr);
        return stringArr;
    }

    private boolean startsWith(String word) {
        return word.indexOf(STARTS_WITH) == 0;
    }
}
