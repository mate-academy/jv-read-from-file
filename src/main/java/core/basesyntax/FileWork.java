package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class FileWork {
    public static final String STRING_DIVIDER = " ";
    public static final String SYMBOLS_TO_EXCLUDE = "[.,?!]";
    public static final String CHARACTER_WE_ARE_LOOKING_FOR = "w";

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        String resultString = "";
        StringBuilder stringBuilder = new StringBuilder(resultString);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split(STRING_DIVIDER);
                for (String str : strings) {
                    String s = str.toLowerCase(Locale.ROOT).replaceAll(
                            SYMBOLS_TO_EXCLUDE, "");
                    if (s.startsWith(CHARACTER_WE_ARE_LOOKING_FOR)) {
                        stringBuilder.append(s).append(STRING_DIVIDER);
                    }
                }
            }
            resultString = stringBuilder.toString();
            if (resultString.equals("")) {
                return new String[0];
            }
            String[] outputArray = stringBuilder.toString().split(STRING_DIVIDER);
            Arrays.sort(outputArray);
            return outputArray;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + fileName, e);
        }
    }
}
