package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();

        String path = "src/main/resources/fileName.txt";

        fileWork.readFromFile(path);
    }
}
