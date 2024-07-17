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
        for (String string : strings) {
            String[] strings1 = fileWork.readFromFile(string);
            System.out.println("File " + string);
            if (strings1 != null){
                for (String name :
                        strings1) {
                    System.out.println(name);
                }
            }else {
                System.out.println("Null....");
            }
        }

    }

    private static void getNameFile(){
        File file = parentDir.toFile();
        int number = 0;
        for (File files : file.listFiles()) {
            strings[number] = files.getPath();
            number++;
        }
    }
}
