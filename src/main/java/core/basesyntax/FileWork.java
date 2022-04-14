package core.basesyntax;

import java.io.*;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here


        return null;
    }

    public String readFile(String fileName) {
        File file = new File(fileName);
        String string;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder builder = new StringBuilder();
            string = bufferedReader.readLine();
            builder.append(string);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return string;
    }
}
