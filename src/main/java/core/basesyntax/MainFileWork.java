package core.basesyntax;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFileWork {
    public static void main(String[] args) {

      FileWork fileWork = new FileWork();
      System.out.println(fileWork.readFromFile("test2"));


//        File file = new File("test2");
//      try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//            System.out.println(bufferedReader.read());
//        } catch (IOException e) {
//            throw new RuntimeException("No file", e);
//     }
//      Path parentDir = Paths.get("test2");
//      System.out.println(parentDir.getParent());
//      System.out.println(parentDir.toAbsolutePath().toString());


    }
}
