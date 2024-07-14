package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        try {
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            String readyString = "";
            for (int i = 0; i < content.length() - 1; i++) {
                if (((i == 0) && ((content.charAt(i) == 'W') || (content.charAt(i) == 'w')))
                        || ((content.charAt(i) == ' ') && ((content.charAt(i + 1) == 'W')
                        || (content.charAt(i + 1) == 'w')))) {
                    for (int j = i + 1; j < content.length(); j++) {
                        if ((content.charAt(j) == ' ') || (j == content.length() - 1)) {
                            if (i == 0) {
                                readyString += content.substring(i,j + 1).toLowerCase();
                            } else {
                                readyString += content.substring(i + 1,j + 1).toLowerCase();
                            }
                            break;
                        }
                    }
                }
            }
            if (readyString == "") {
                return new String[0];
            }
            String[] wordsArray = readyString.split("[\\W]+");
            Arrays.sort(wordsArray);
            return wordsArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }
}
