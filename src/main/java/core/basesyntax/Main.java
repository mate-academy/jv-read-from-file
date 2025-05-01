package core.basesyntax;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();

        String projectPath = System.getProperty("user.dir");
        System.out.println("Current working directory: " + projectPath);

        for (int i = 1; i <= 5; i++) {
            String fileName = projectPath + File.separator + "test" + i + ".txt";
            System.out.println("📂 Testing file: " + fileName);

            try {
                String[] result = fileWork.readFromFile(fileName);
                System.out.println("✅ Result: " + Arrays.toString(result));
            } catch (RuntimeException e) {
                System.out.println("❌ " + e.getMessage());
            }

            System.out.println("--------------------------------");
        }
    }
}
