package core.basesyntax;


public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        fileWork.readFromFile("test1");
        fileWork.readFromFile("test2");
        fileWork.readFromFile("test3");
        fileWork.readFromFile("test4");
        fileWork.readFromFile("test5");
    }

}
