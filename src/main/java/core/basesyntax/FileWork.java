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
        //write your code here
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        if (file.length() == 0) {
            return new String[]{};
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                str.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }

        String[] words = str.toString().toLowerCase().split("\\W+");

        for (String word : words) {
            if (word.charAt(0) == 'w') {
                list.add(word);
            }
        }
        Collections.sort(list);
        String[] arr = new String[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}
