package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //GET STRING FROM FILE---------------------
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        File file = new File(fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read", e);
        }
        //COUNT NEEDED WORDS---------------------
        if (stringBuilder.toString() == "") {
            return new String [0];
        }
        String[] split = stringBuilder.toString().split("\\W+");

        for (int i = 0; i < split.length; i++) {
            if (split[i].toLowerCase().charAt(0) == 'w') {
                count++;
            }
        }
        //PUT WORDS TO NEW ARRAY---------------------
        String[] resultStringArray = new String[count];
        count = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].toLowerCase().charAt(0) == 'w') {
                resultStringArray[count] = split[i].toLowerCase();
                count++;
            }
        }
        Arrays.sort(resultStringArray);
        System.out.println(Arrays.asList(resultStringArray));
        return resultStringArray;
    }
}
