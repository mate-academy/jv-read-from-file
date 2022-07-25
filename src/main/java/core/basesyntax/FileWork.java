package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                value = value.toLowerCase().replaceAll("\\b(?!w)\\w+\\W*", "");
                value = value.replaceAll("[.]","");
                if (value.equals("")) {
                    String[] words = value.split("[\\W++&&[^-]]");
                    stringBuilder.append(Arrays.toString(words));
                }
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return null;
    }
}
