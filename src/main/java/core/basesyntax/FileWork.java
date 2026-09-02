package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(" ");
                value = reader.readLine();
            }
            String additionalString = stringBuilder.toString().toLowerCase();
            String[] additionalArray = additionalString.split("\\W+");
            for (String s : additionalArray) {
                if (s.startsWith(SPECIFIED_CHARACTER)) {
                    builder.append(s).append(" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] answer = builder.toString().split(" ");
        if (answer.length == 0 || answer.length == 1) {
            return new String [] {};
        }
        Arrays.sort(answer);
        return answer;
    }
}
