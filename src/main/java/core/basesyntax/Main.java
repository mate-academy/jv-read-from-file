package core.basesyntax;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static Path parentDir = Paths.get("./file");
    private static String[] strings = new String[parentDir.toFile().listFiles().length];

    public static void main(String[] args){
        getNameFile();
        FileWork fileWork = new FileWork();
        for (int i = 0; i < strings.length; i++) {
            fileWork.readFromFile(strings[i]);
        }
    }

    private static void getNameFile(){
        File file = parentDir.toFile();
        int num = 0;
        for (File files : file.listFiles()) {
            strings[num] = files.getName();
            num++;
        }
    }
}
