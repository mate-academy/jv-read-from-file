package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String text = "Beautiful two-bedroom city flat five minutes'"
                + " walk from the cathedral.\n"
                + "Fully equipped kitchen, living room with a large "
                + "sofa and chairs, big TV and balcony.\n"
                + "The balcony has space for four people to sit and "
                + "gets the sun in the mornings,\n"
                + "and the flat is light and warm. The upstairs bedroom"
                + " sleeps four people, with two double beds;\n"
                + "the downstairs bedroom sleeps two in single beds.\n"
                + "The flat is perfect for families and is near shops,"
                + "bars and restaurants.";
        BufferedWriter writer = null;
        String filePath = null;
        try {
            File folder = new File("myFolder2");
            folder.mkdir();

            filePath = "myFolder2" + File.separator + "text.txt";
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
        String[] result = fileWork.readFromFile(filePath);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
