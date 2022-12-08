package core.basesyntax;

import java.io.*;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here

        final int ARR_SIZE = 100;

        File file = new File(fileName);
        String[] result = new String[ARR_SIZE];
        StringBuilder string = new StringBuilder();
        int wordCounter = 0;

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(file));
            String value = buffReader.readLine();
            String[] lines = new String[ARR_SIZE];
            while (value != null) {
                lines = value.split(" ");
                for (String checker : lines) {
                    char[] charArr = new char[ARR_SIZE];
                    charArr = checker.toCharArray();
                    for (int i = 0; i < charArr.length(); i++) {
                        if (charArr[i] != "." || charArr[i] != "," || charArr[i] != "!"
                                || charArr[i] != "?" || charArr[i] != "'" || charArr[i] != ":"
                                || charArr[i] != ";") {
                            string.append(charArr[i]);
                        }
                    }
                    result[wordCounter] = string.toString().toLowerCase();
                    string.setLength(0);
                    wordCounter++;
                }
                value = buffReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot open file", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
