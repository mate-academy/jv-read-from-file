package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String SPECIFIED_CHARACTER = "w";
    private int specCharRepeated = 0;

    public boolean startWithLetter(String word) {
        return word.startsWith(SPECIFIED_CHARACTER);
    }

    private void arraySort(String[] result) {

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].compareTo(result[j]) < 0) {
                    String temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
            if (startWithLetter(result[i])) {
                specCharRepeated++;
            }
        }
    }

    public String[] readFromFile(String fileName) {
        String[] output;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            String[] result = stringBuilder.toString().toLowerCase().split("\\W+");
            arraySort(result);
            output = new String[specCharRepeated];
            for (String string : result) {
                if (startWithLetter(string)) {
                    output[--specCharRepeated] = string;
                }
                if (specCharRepeated == 0) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file", e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException("Cant close bufferReader", e);
                }
            }
        }
        return output;
    }
}
