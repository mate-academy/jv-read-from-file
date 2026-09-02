package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        boolean wasW = false;
        int previousSymbol = -1;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int currentSymbol = reader.read();
            while (currentSymbol != -1) {
                if (((currentSymbol == 'w' || currentSymbol == 'W') 
                        && (previousSymbol == -1 || previousSymbol == ' ' 
                        || previousSymbol == '\n') || wasW == true) 
                        && currentSymbol != '.' && currentSymbol != ',' 
                        && currentSymbol != '!' && currentSymbol != '?') {
                    if (currentSymbol == ' ' || currentSymbol == '\n') {
                        wasW = false;
                        builder.append(' ');
                        continue;
                    }                 
                    builder.append((char)currentSymbol);
                    wasW = true;
                }
                previousSymbol = currentSymbol;
                currentSymbol = reader.read();
            }  
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }               
        String[] resultArray = builder.toString().equals("") 
                ? new String[0] : builder.toString().toLowerCase().split(" ");
        Arrays.sort(resultArray);
        return resultArray;
    }
}
