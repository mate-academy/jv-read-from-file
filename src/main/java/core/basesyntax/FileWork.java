package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileWork {
    public String[] readFromFile(String fileName) {
        ArrayList<String> output = new ArrayList<String>();
        String material = "";
        if (fileName.length() == 0) {
            return new String[fileName.length()];
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = bufferedReader.readLine();
            }
            material = stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
        for (int i = material.length() - 1, j = material.length() - 1; i >= 0; i--) {
            if (material.toCharArray()[i] == ' ' || material.toCharArray()[i] == ','
                    || material.toCharArray()[i] == '.' || material.toCharArray()[i] == ';'
                    || material.toCharArray()[i] == ':' || material.toCharArray()[i] == '!'
                    || material.toCharArray()[i] == '?') {
                j = i;
            }
            if (Character.toLowerCase(material.toCharArray()[i]) == 'w'
                    && (i == 0 || material.toCharArray()[i - 1] == ' ')
                    && (material.toCharArray()[j] == ' ' || material.toCharArray()[j] == ','
                    || material.toCharArray()[j] == '.' || material.toCharArray()[j] == ';'
                    || material.toCharArray()[j] == ':' || material.toCharArray()[j] == '!'
                    || material.toCharArray()[j] == '?')) {
                output.add(0, material.substring(i, j).toLowerCase());
            }
        }
        Collections.sort(output);
        return output.toArray(new String[0]);
    }
}
