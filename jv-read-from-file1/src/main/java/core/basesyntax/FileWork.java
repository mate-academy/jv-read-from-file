package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileWork {
    public String[] readFromFile(String fileName) throws FileNotFoundException {
        File m = new File("test1");
        File my = new File("test2");
        File myf = new File("test3");
        File myfi = new File("test4");
        File myfil = new File("test5");
        FileReader fileReader = new FileReader(m);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

    }
}
