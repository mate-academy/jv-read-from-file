package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {
    private static final char SPECIFIC_CHARACTER = 'w';
    private static final char SPECIFIC_CHARACTER_UPPER = 'W';

    public String[] readFromFile(String fileName) {
        ArrayList<String> stringList;
        String tempStr;
        try (FileReader fileReaderTwoText = new FileReader(fileName)) {
            String text;
            int temp;
            stringList = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(fileReaderTwoText);
            while ((text = bufferedReader.readLine()) != null) {
                temp = 0;
                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == ' ' || text.charAt(i) == ','
                            || text.charAt(i) == '.' || text.charAt(i) == '?'
                            || text.charAt(i) == '!' || i == text.length() - 1) {
                        if (!text.substring(temp, i).equals("")) {
                            if (text.charAt(temp) == SPECIFIC_CHARACTER
                                    || text.charAt(temp) == SPECIFIC_CHARACTER_UPPER) {
                                if (i != text.length() - 1) {
                                    stringList.add(text.substring(temp, i).toLowerCase());
                                } else {
                                    stringList.add(text.substring(temp, i + 1).toLowerCase());
                                }
                            }
                        }
                        temp = i + 1;
                    }
                }
            }
            bufferedReader.close();
            stringList.trimToSize();
        } catch (IOException e) {
            throw new RuntimeException("File was`t read", e);
        }

        for (int i = 0; i < stringList.size(); i++) {
            for (int j = i + 1; j < stringList.size(); j++) {
                if (stringList.get(i).compareTo(stringList.get(j)) > 0) {
                    // swapping
                    tempStr = stringList.get(i);
                    stringList.set(i, stringList.get(j));
                    stringList.set(j, tempStr);
                }
            }
        }
        return stringList.toArray(new String[0]);
    }
}
