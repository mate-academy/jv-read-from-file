package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    private static final int FIRST_CHAR = 0;

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return new String[0];
        } else {
            StringBuilder stringContent = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String readLine = reader.readLine();
                while (readLine != null) {
                    stringContent.append(readLine).append(" ");
                    readLine = reader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't read the file", e);
            }
            StringBuilder supportString = new StringBuilder();
            String[] lookingArray;
            String[] contentArray = stringContent.toString().toLowerCase().split("\\W+");
            for (String content : contentArray) {
                if (content.charAt(FIRST_CHAR) == 'w') {
                    supportString.append(content).append(" ");
                }
            }
            if (supportString.length() == 0) {
                return new String[0];
            } else {
                lookingArray = supportString.toString().split(" ");
                Arrays.sort(lookingArray);
                return lookingArray;
            }
        }
    }
}
