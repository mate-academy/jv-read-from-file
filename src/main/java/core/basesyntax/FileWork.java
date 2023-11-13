package core.basesyntax;

import java.io.*;

public class FileWork {
    private Object builder;

    public String[] readFromFile(String fileName) throws FileNotFoundException {


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                line.replaceAll(("[^a-zA-Z]"), " ");
                String[] words = line.split("\\S+");
                for (String word : words) {
                    if (word.toLowerCase().startsWith("w")) {

                     StringBuilder   builder = new StringBuilder(word);
                        builder.append(word);
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(" Can`t read from file", e);
        }
        return new String[]{builder.toString()};
    }
}
