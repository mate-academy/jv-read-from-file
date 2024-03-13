package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();
        String stringEndsWithPoint = ".";
        String stringEndsWithQuestionmark = "?";
        String stringEndsWithExclemationmark = "!";
        String startWithW = "w"; //constant fields

        try { //file to String
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String stringFromFile = builder.toString().toLowerCase().replace("\n"," ");
        String[] stringTableFromFile = stringFromFile.split(" ");//String to table

        int counter = 0;

        for (int i = 0; i < stringTableFromFile.length; i++) { //Counter for final table
            if (stringTableFromFile[i].startsWith(startWithW)) {
                counter++;
            }
        }

        String[] finalString = new String[counter];
        int finalStringCounter = 0;

        for (int i = 0; i < stringTableFromFile.length; i++) { //filling new table
            String temporary = stringTableFromFile[i].trim();
            if (temporary.startsWith(startWithW)) {
                if (
                        temporary.endsWith(stringEndsWithPoint)
                        || temporary.endsWith(stringEndsWithExclemationmark)
                        || temporary.endsWith(stringEndsWithQuestionmark)
                ) {
                    finalString[finalStringCounter++] =
                            temporary.substring(0, temporary.length() - 1);
                } else {
                    finalString[finalStringCounter++] =
                            temporary;
                }
            }
        }
        Arrays.sort(finalString);//sorting table

        return finalString;
    }
}
