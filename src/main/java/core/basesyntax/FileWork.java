package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
        } catch (IOException e){
            throw new RuntimeException("Can't reade from file!");
        }
        return ;
    }
}
