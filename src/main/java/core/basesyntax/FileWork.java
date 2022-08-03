package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        //write your code here
        String file = null;
        File file1 = new File(fileName);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file1));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            file = stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file.", e);
        }
        if ((file.length() == 0) || (file == null)) {
            return new String[0];
        }
        file = file.toLowerCase();
        System.out.println(file);
        String[] array = file.split("\\W+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i].substring(0, 1).equals("w")) {
                sb.append(array[i]).append(" ");
            }
        }
        if (sb.toString().length() == 0) {
            return new String[0];
        }
        String[] str = sb.toString().split(" ");
        str = Stream.of(str)
                .sorted()
                .toArray(String[]::new);
        return (str);
    }
}
