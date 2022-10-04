package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String strFile = "";
        try {
            String value = bufferedReader.readLine();
            while (value != null) {
                strFile += value + " ";
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (strFile.equals("")) {
            return new String[0];
        }

        String[] fileSplit = strFile.toLowerCase().split("[ ,\\.\\?!]+");
        String answer = "";
        for (int i = 0; i < fileSplit.length; i++) {
            char[] charWords = fileSplit[i].toCharArray();
            if (charWords[0] == 'w') {
                answer += fileSplit[i] + " ";
            }
        }

        if (answer.equals("")) {
            return new String[0];
        }

        String[] answer2 = answer.split(" ");
        Arrays.sort(answer2);

        return answer2;
    }
}
