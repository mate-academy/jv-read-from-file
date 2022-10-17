package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        File file = new File(fileName);
        String temp;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                builder.append((char) value);
                value = reader.read();
            }
            String str = builder.toString();
            String[] str2 = str.toLowerCase().split("[!.',? \n]");
            ArrayList<String> list = new ArrayList<>();
            int count = 0;
            for (String s : str2) {
                temp = s;
                if ((temp.startsWith("w"))) {
                    list.add(temp);
                }
            }
            String[] result = new String[list.size()];
            list.toArray(result);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (result[i].compareTo(result[j]) > 0) {
                        temp = result[i];
                        result[i] = result[j];
                        result[j] = temp;
                    }
                }
            }
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
