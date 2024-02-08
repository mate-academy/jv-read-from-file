package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        char specifiedCharacter = 'w';
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String value = reader.readLine();
            while (value != null) {
                if (Objects.equals(Character.toLowerCase(value.charAt(0)),
                        specifiedCharacter)) {
                    stringBuilder.append(value);
                    value = reader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result = stringBuilder.toString().split(",");
        return result;
    }
}
