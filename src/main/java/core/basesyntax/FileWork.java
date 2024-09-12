package core.basesyntax;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;

public class FileWork {
    String fileForRead = "fileForRead.txt";
    String lowerString = "";

    public String[] readFromFile(String fileForRead) {
        StringBuilder stringBuilder = new StringBuilder();
        File myFile = new File(fileForRead);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForRead))) {
            FileReader fileReader = new FileReader(myFile);
            // BufferedReader bufferedReader = new BufferedReader(fileReader);
            String value = bufferedReader.readLine();
            while (value != null) {
                stringBuilder.append(lowerString).append(System.lineSeparator());
                System.out.println(value);
                value = bufferedReader.readLine();
                if(value != null) {
                    String[] split = value.split("\\W+");
                    String string = Arrays.toString(split);
                    lowerString = string.toLowerCase();
                }
            }
        } catch(IOException e) {
            throw new RuntimeException("Can't read file", e);
        } finally {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForRead))) {
                bufferedReader.close();
                return readFromFile(fileForRead);
                } catch(IOException e) {
                    throw new RuntimeException("Can't read file", e);
                }
            }
        }
    }

