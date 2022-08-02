package core.basesyntax;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import java.util.Arrays;

public class FileWork {
    private static final String Letter = "w";

    public String[] readFromFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int value = reader.read();
            while (value != -1){
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't a read file.", e);
        }

        String[] fileArray = stringBuilder.toString().split("[\\p{Punct}\\s]+");
        stringBuilder.setLength(0);

        for (int i = 0; i < fileArray.length; i++){
            fileArray[i] = fileArray[i].toLowerCase(Locale.ROOT);
            if(start(fileArray[i])){
                stringBuilder.append(fileArray[i]).append(" ");
            }
        }

        if (stringBuilder.length() == 0) {
            return new String[0];
        }
        String[] newArray = stringBuilder.toString().split(" ");
        Arrays.sort(newArray);

        return newArray;

    }
    public boolean start(String word) {
        return word.startsWith(Letter);
    }
}
