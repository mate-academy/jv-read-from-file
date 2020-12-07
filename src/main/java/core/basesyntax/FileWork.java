package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;

public class FileWork {

    public String[] readFromFile(String fileName) {
        StringBuilder file = new StringBuilder();
        String[] readFromFile = new String[] {};
        ArrayList<String> read = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new
                FileReader((fileName)))) {
            String newLine = bufferedReader.readLine();
            while (newLine != null) {
                file.append(newLine.toLowerCase()).append(" ");
                newLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("File was not written ");
        }
        readFromFile = file.toString().split(" ");
        for (String readFile : readFromFile) {
            if (startsWith(readFile)) {
                read.add(readFile.replaceAll("[,.!?]", ""));
            }
        }
        readFromFile = new String[read.size()];
        Collections.sort(read);
        read.toArray(readFromFile);
        return readFromFile;
    }

    private boolean startsWith(String word){

        return word.indexOf('w') == 0;
    }
}
