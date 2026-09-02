package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileWork {
    public String[] readFromFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
            String strb = new String(stringBuilder);
            String [] arrOfStrings = strb.split("[^a-zA-Z0-9]");

            for (int i = 0; i < arrOfStrings.length; i++) {
                arrOfStrings[i] = arrOfStrings[i].toLowerCase();
            }
            for (int i = 0; i < arrOfStrings.length; i++) {
                if (arrOfStrings[i].contains("w")) {
                    if (arrOfStrings[i].charAt(0) == 'w') {
                        stringList.add(arrOfStrings[i]);
                    }
                }
            }

            Collections.sort(stringList);
            for (String str: stringList
                 ) {
                System.out.print(str + " ");
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't read the file");
        }

        String [] resultArray = new String[stringList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = stringList.get(i);
        }
        return resultArray;
    }
}
