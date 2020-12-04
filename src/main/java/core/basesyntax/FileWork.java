package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder file = new StringBuilder();
        String[] readFromFile = new String[] {};
        ArrayList<String> read = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new
                    InputStreamReader(new FileInputStream(fileName)));
            String newLine = bufferedReader.readLine();
            while (newLine != null) {
                file.append(newLine.toLowerCase(Locale.ROOT)).append(" ");
                newLine = bufferedReader.readLine();
            }
            readFromFile = file.toString().split(" ");
            for (int i = 0; i < readFromFile.length; i++) {
                if (readFromFile[i].indexOf('w') == 0) {
                    if (readFromFile[i].indexOf(',') >= 0
                            || readFromFile[i].indexOf('.') >= 0
                            || readFromFile[i].indexOf('!') >= 0
                            || readFromFile[i].indexOf('?') >= 0) {
                        readFromFile[i] = readFromFile[i]
                                .substring(0, readFromFile[i].length() - 1);
                    }
                    read.add(readFromFile[i]);
                }
            }
            Collections.sort(read);
            readFromFile = new String[read.size()];
            for (int i = 0; i < read.size(); i++) {
                readFromFile[i] = read.get(i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("In file smth strage, i do not read it!");
        }
        return readFromFile;
    }
}
