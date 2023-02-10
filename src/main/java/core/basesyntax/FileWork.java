package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        String string;
        try {
            File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            string = bufferedReader.readLine();
            while (string != null) {
                stringBuilder.append(string).append(" ");
                string = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data with file", e);
        }
        if (stringBuilder.toString().isEmpty()) {
            String [] empty = {};
            return empty;
        } else {
            String[] text = stringBuilder.toString().split("\\W+");
            String[] result = getWordsWithW(text);
            Arrays.sort(result);
            return result;
        }
    }

    private String[] getWordsWithW(String[] str) {
        String[] array = new String[str.length];
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (haveW(str[i].toLowerCase())) {
                array[index] = str[i].toLowerCase();
                index++;
            }
        }
        String[] strings = new String[index];
        for (int i = 0; i < index; i++) {
            strings[i] = array[i];
        }
        return strings;
    }

    private boolean haveW(String str) {
        char[] arr = str.toCharArray();
        if (arr[0] == 'w') {
            return true;
        } else {
            return false;
        }
    }
}
