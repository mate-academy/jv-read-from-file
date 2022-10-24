package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String SEARCHING_LETTER_LOW = "w";
    private static final String SEARCHING_LETTER_UP = "W";
    public String[] readFromFile(String fileName) {
        //write your code here
        String[] arrStr = new String[0];
        String tmp;
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder(4096);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            tmp = bufferedReader.readLine();
            if (tmp == null) {
                return arrStr;
            }
            while (tmp != null) {
                arrStr = tmp.split("[!?;:^,.'\"\\- ]");
                for (String str : arrStr) {
                    if (str.startsWith(SEARCHING_LETTER_LOW) || str.startsWith(SEARCHING_LETTER_UP)) {
                        stringBuilder.append(str.toLowerCase()).append(" ");
                    }
                }
                tmp = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        arrStr = stringBuilder.toString().split(" ");
        return arrStr;
    }
}
