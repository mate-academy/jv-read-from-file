package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value);
                value = reader.readLine();
            }
            String[] examples = stringBuilder.toString().toLowerCase().split("\\W+");
            StringBuilder word = new StringBuilder();
            for (String exam: examples) {
                if (exam.startsWith(SPECIFIED_CHARACTER)) {
                    word.append(exam).append(" ");
                }
            }
            String[] total = word.toString().split(" ");
            System.out.println(Arrays.asList(total));
            return total;

        } catch (IOException e) {
            throw new RuntimeException("cant read the file", e);
        }
    }
}
