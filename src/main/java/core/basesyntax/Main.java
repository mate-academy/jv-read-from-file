package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        fileWork.readFromFile("test2");
        System.out.println(fileWork);
    }
}
