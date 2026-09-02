package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileMateAcademy {
    private final String filePath =
            "C:\\Users\\Nutzer\\IdeaProjects\\jv-read-from-file\\src\\main\\resources\\"
                    + "fileName.txt";

    public File createNewFile() {
        File fileName = new File(filePath);

        fileName.getParentFile().mkdirs();

        try {
            fileName.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file");
        }
        return fileName;
    }

    public File writeToFile(String fileName) {

        String [] text = new String []{
                "WWW? Four-bedroom farmhouse in the countryside. "
                        + "Wave! All of the four double bedrooms are en suite."
        };

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String word : text) {
                bufferedWriter.write(word);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write date to file");
        }
        return new File(fileName);
    }
}
