package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            builder = new StringBuilder();
            String text = reader.readLine();
            if (text == null) {
                return new String[0];
            }
            while (text != null) {
                String[] slova = text.split("\\W+");
                for (int i = 0; i < slova.length; i++) {
                    slova[i] = slova[i].toLowerCase();
                    if (slova[i].charAt(0) == 'w') {
                        builder.append(slova[i]).append(" ");
                    }
                }
                text = reader.readLine();
            }
            String result = builder.toString();
            if (result.equals("")) {
                return new String[0];
            }
            String [] finish = result.split(" ");
            Arrays.sort(finish);
            return finish;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
