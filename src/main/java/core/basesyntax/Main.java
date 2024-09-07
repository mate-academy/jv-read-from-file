package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text = "Whenever I have gone there, there have been either so many\n"
                + "people that I have not been able to see the pictures, which\n"
                + "was dreadful, or so many pictures that I have not been able to "
                + "see the people, which was\n"
                + "worse. The Grosvenor is really the only place.";
        BufferedWriter writer = null;
        String filePath = null;
        try {
            File folder = new File("myFolder2");
            folder.mkdir();

            filePath = "myFolder2" + File.separator + "text.txt";
            File file = new File(filePath);
            file.createNewFile();

            writer = new BufferedWriter(new FileWriter(file));
            writer.write(text.toLowerCase());
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close file", e);
                }
            }
        }
        FileWork fileWork = new FileWork();
        String[] result = fileWork.readFromFile(filePath);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
