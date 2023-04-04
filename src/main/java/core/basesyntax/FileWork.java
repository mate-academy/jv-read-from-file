package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {

            String[] total = new String[]{};
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                StringBuilder stringBuilder = new StringBuilder();
                String value = reader.readLine();
                while (value != null) {
                    stringBuilder.append(value);
                    System.out.println(stringBuilder);
                    value = reader.readLine();
                }


            } catch (IOException e) {
                throw new RuntimeException("cant read the file", e);
            }

            return null;
    }
}
