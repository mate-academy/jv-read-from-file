package core.basesyntax;

import java.io.*;

public class FileWork {
    public static final String SPECIFIC_CHAR = "w";

    public String[] readFromFile(String fileName) {
        //write your code here
      //  return null;
        File file = new File(fileName);
        String readFrom = null;
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null){
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't find the file, or read file");
        }
        readFrom = builder.toString();

        if (readFrom.isEmpty()) {
            return new String[0];
        }

    }
}
