package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMateAcademy {
    private final String filePath = "resources" + File.separator + "fileName.txt";

    public File createNewFile(String path) {
            File fileName = new File(filePath);

            try {
            fileName.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException ("Can't create new file");
        }
            return fileName;
    }

    public File writeToFile(String fileName) {

        try (BufferedWriter bufferedWriter =  new BufferedWriter(new FileWriter(fileName, true))){
            for(String word : text) {
                bufferedWriter.write(word);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException ("Can't write date to file");
        }
        return new File(fileName);
    }
}
