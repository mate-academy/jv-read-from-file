package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {

    public String[] readFromFile(String fileName) {
        String[] readFromFile;
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
           throw new RuntimeException("File was not found");
        } catch (IOException e) {
            throw new RuntimeException("File was not written ");
        }
        readFromFile = stringBuilder.toString().split(" ");
        for (String readFile : readFromFile) {
            if (startsWith(readFile)) {
                arrayList.add(readFile.replaceAll("[,.!?]", ""));
            }
        }
        readFromFile = new String[arrayList.size()];
        Collections.sort(arrayList);
        arrayList.toArray(readFromFile);
        return readFromFile;
    }

    private boolean startsWith(String word) {

        return word.indexOf('w') == 0;
    }
}
