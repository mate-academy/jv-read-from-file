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
        File file = new File(fileName);
        String line;
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            line = reader.readLine();
            while (line != null) {
                text.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        String resultingString = text.toString();
        if (resultingString.length() == 0) {
            return new String[] {};
        }
        String[] tempArray = resultingString.split("\\W+");
        List<String> res = new ArrayList<>();
        for (String result : tempArray) {
            if (result.charAt(0) == 'w' || result.charAt(0) == 'W') {
                res.add(result.toLowerCase());
            }
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}
