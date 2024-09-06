package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text = "Four-bedroom farmhouse in the countryside. "
                + "All of the four double bedrooms are en suite.\n"
                + "Farm kitchen, tables and chairs outside. Great "
                + "for groups of friends. The supermarket is half\n"
                + "an hour by car and you can take a train from the "
                + "village into the city. Escape from normal life\n"
                + "for a few days.\n";
        BufferedWriter writer = null;
        try {
            File folder = new File("myFolder2");
            folder.mkdir();

            String filePath = "myFolder2" + File.separator + "text.txt";
            File file = new File(filePath);
            file.createNewFile();

            writer = new BufferedWriter(new FileWriter(file, true));
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
        String[] result = fileWork.readFromFile("text.txt");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
