package core.basesyntax;

public class Main {
    public static void main(String[] split) {
        String fileForRead = "fileForRead.txt";

        FileWork fileWork = new FileWork();
        fileWork.readFromFile(fileForRead);
    }
}
