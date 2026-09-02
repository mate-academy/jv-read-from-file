package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        String[] test5s = fileWork.readFromFile("test5");
        for (String s : test5s) {
            System.out.println(s);
        }
    }
}
