package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                StringBuilder stringBuilder = new StringBuilder();
                String value = reader.readLine();
                while (value != null) {
                        stringBuilder.append(value);
                        value = reader.readLine();
                }
                String[] examples = stringBuilder.toString().toLowerCase().split(" ");
                StringBuilder word = new StringBuilder();
                for (String exam: examples) {
                    if (exam.contains("w")) {
                        word.append(exam).append(" ");
                    }
                }
                String[] total = word.toString().split("\\W+");
                StringBuilder builder = new StringBuilder();
                for (String string : total) {
                    if (string.startsWith("w")) {
                        builder.append(string).append(" ");
                    }
                }
                String[] result = builder.toString().toLowerCase().split(" ");
                System.out.println(Arrays.toString(result));

            } catch (IOException e) {
                throw new RuntimeException("cant read the file", e);
            }
            return null;
    }
}
